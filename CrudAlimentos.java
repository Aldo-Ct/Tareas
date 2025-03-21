/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudalimentos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class CrudAlimentos {

    ArrayList<String> productos = new ArrayList<>();
    ArrayList<Double> precios = new ArrayList<>();
    Scanner slark = new Scanner(System.in);
    Random recomendacion = new Random();

    public static void main(String[] args) {
        CrudAlimentos app = new CrudAlimentos();
        app.inicializarProductos();
        app.bienvenida();
        app.menu();
    }

    public void bienvenida() {
        int promocionaleatoria = recomendacion.nextInt(productos.size());
        System.out.println("\n--------Bienvenidos a mi tiendita!-----------");
        System.out.println("🎉 La promoción recomendada de hoy es: " + productos.get(promocionaleatoria) +
                " por solo S/ " + String.format("%.2f", precios.get(promocionaleatoria)) + " 🎉");
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = slark.nextInt();
            slark.nextLine();

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> mostrarProductos();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public void inicializarProductos() {
        productos.add("Muffin de Chocolate"); precios.add(8.50);
        productos.add("Galleta de Chispas"); precios.add(5.00);
        productos.add("Brownie Clásico"); precios.add(7.50);
        productos.add("Croissant Mantequilla"); precios.add(6.00);
        productos.add("Cheesecake Fresa"); precios.add(12.00);
        productos.add("Empanada de Pollo"); precios.add(9.00);
        productos.add("Torta de Zanahoria"); precios.add(10.50);
        productos.add("Sandwich de Pavo"); precios.add(15.00);
        productos.add("Cake Pop Vainilla"); precios.add(6.50);
        productos.add("Panini Caprese"); precios.add(14.00);
    }

    public void agregarProducto() {
        if (productos.size() >= 20) {
            System.out.println("No se pueden agregar más de 20 productos.");
            return;
        }
        System.out.print("Ingrese el nombre del producto: ");
        String producto = slark.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = slark.nextDouble();
        slark.nextLine();
        productos.add(producto);
        precios.add(precio);
        System.out.println("Producto agregado con éxito.");
    }

    public void mostrarProductos() {
        System.out.println("\nLista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.printf("%d. %s - S/ %.2f\n", i + 1, productos.get(i), precios.get(i));
        }
    }

    public void actualizarProducto() {
        mostrarProductos();
        System.out.print("Ingrese el número del producto a actualizar: ");
        int Elecciondeproducto = slark.nextInt() - 1;
        slark.nextLine();
        if (Elecciondeproducto >= 0 && Elecciondeproducto < productos.size()) {
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = slark.nextLine();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = slark.nextDouble();
            slark.nextLine();
            productos.set(Elecciondeproducto, nuevoNombre);
            precios.set(Elecciondeproducto, nuevoPrecio);
            System.out.println("Producto actualizado.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    public void eliminarProducto() {
        mostrarProductos();
        System.out.print("Ingrese el número del producto a eliminar: ");
        int numerodeproducto = slark.nextInt() - 1;
        slark.nextLine();
        if (numerodeproducto >= 0 && numerodeproducto < productos.size()) {
            productos.remove(numerodeproducto);
            precios.remove(numerodeproducto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
