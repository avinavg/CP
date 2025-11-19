package com.leetcode.io;

import java.util.*;

public class MainTest {

    // --- Mock Database ---
    private static final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 1000, 5),
            new Product(2, "Phone", 500, 10),
            new Product(3, "Headphones", 100, 20)
    ));
    // Cart is stored per user ID
    private static final Map<String, List<CartItem>> userCarts = new HashMap<>();

    /**
     * Simulates GET /products
     *
     * @return A list of available products.
     */
    //Working fine
    public static List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Simulates POST /cart/{userId}
     *
     * @param userId The ID of the user whose cart is being modified.
     * @param item   The CartItem object to add (productId, quantity).
     * @return A Map representing the API response (success/error, and current cart state).
     */

    public static Map<String, Object> addToCart(String userId, CartItem item) {
        System.out.println("Item to vbe added id:" + item.productId);
        Product product = products.stream().filter(p -> p.id == item.productId).findFirst().orElse(null);
        int neededQuantity = item.getQuantity();
        List<CartItem> cart = userCarts.get(userId);

        for (CartItem existingItem : cart) {
            if (product != null && product.quantity >= neededQuantity) {
                existingItem.quantity += item.quantity;
            }
            updateProductQuantity(product, neededQuantity);
        }

        userCarts.replace(userId, cart);
        return Map.of("success", true, "cart", new ArrayList<>(cart));

    }


    // --- Simulated Endpoints (Functions to call) ---

    static void updateProductQuantity(Product product, int neededQuantity) {
        int newQuantity = product.quantity - neededQuantity;
        products.remove(product);
        product.quantity = newQuantity;
        products.add(product);
        System.out.println("New Product with quantity" + products.get(product.id));
    }

    /**
     * Simulates GET /cart/{userId}
     *
     * @param userId The ID of the user whose cart is to be viewed.
     * @return A List of CartItem objects in the user's cart, or null if cart doesn't exist.
     */
    public static List<CartItem> viewCart(String userId) {
        List<CartItem> cart = userCarts.get(userId);
        if (cart == null) {
            return null;
        }
        return new ArrayList<>(cart);
    }

    /**
     * Simulates DELETE /cart/{userId}
     *
     * @param userId    The ID of the user whose cart is being modified.
     * @param productId The ID of the product to remove.
     * @return A Map representing the API response (success/error, and current cart state).
     */
    public static Map<String, Object> removeFromCart(String userId, int productId) {
        if (!userCarts.containsKey(userId)) {
            return Map.of("error", "Cart not found");
        }

        List<CartItem> cart = userCarts.get(userId);
        Optional<CartItem> item = cart.stream().filter(i -> i.productId == productId).findFirst();

        if (item.isEmpty()) {
            return Map.of("error", "Product not found in cart");
        }

        cart.remove(item.get());
        return Map.of("success", true, "cart", new ArrayList<>(cart));
    }

    /**
     * Simulates POST /checkout/{userId}
     *
     * @param userId The ID of the user checking out.
     * @return A Map representing the API response (success/error, and total amount).
     */
    public static Map<String, Object> checkout(String userId) {
        List<CartItem> cart = userCarts.get(userId);
        double total = 0;
        for (CartItem item : cart) {
            Product product = products.stream().filter(p -> p.id == item.productId).findFirst().orElse(null);
            total += product.price * item.quantity;
            product.quantity -= item.quantity;
        }

        return Map.of("success", true, "total", total);
    }

    // --- Main method for local execution ---
    public static void main(String[] args) {
        System.out.println("--- Starting Shopping Cart Simulation ---");
        System.out.println(getProducts());
        String userId = "user1";
        CartItem item = new CartItem(1, 2);
        CartItem newItem = new CartItem(2, 6);
        List<CartItem> items = new ArrayList<>();
        items.add(item);
        userCarts.put(userId, items);
        System.out.println(userCarts);
        addToCart(userId, item);
        addToCart(userId, newItem);
        System.out.println(viewCart(userId));
        System.out.println("\n--- End Simulation ---");
    }

    // --- Data Models ---
    static class Product {
        public int id;
        public String name;
        public double price;
        public int quantity;

        public Product(int id, String name, double price, int stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = stock;
        }

        // Added for easier printing/debugging
        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + ", stock=" + quantity + '}';
        }
    }

    static class CartItem {
        public int productId;
        public int quantity;


        public CartItem(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        int getQuantity() {
            return quantity;
        }

        // Added for easier printing/debugging
        @Override
        public String toString() {
            return "CartItem{productId=" + productId + ", quantity=" + quantity + '}';
        }
    }
}