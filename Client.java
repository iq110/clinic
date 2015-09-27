import Pets.Cat;
import Pets.Dog;
import Pets.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Серега on 21.09.2015.
 */
public class Client {

    private String name;// client's name
    private ArrayList<Pet> pets = new ArrayList<Pet>(); // client's pets


    public Client(String clientName) {
        this.name = clientName;
    }//Constructor


    public String getName() {
        return this.name;
    }
    public void setName(String n) {
        this.name = n;
    }


    /**
     * Has client some pet or no
     *
     * @param petName
     * @return true-yes, false-didn't
     */
    public boolean hasPet(String petName) {
        for (Pet p : pets) {
            if (p.getName().equals(petName))
                return true;
        }
        return false;
    }
    /**
     * @param petName
     * @return pet's name if OK, "null" if clients has no pet with this name
     */
    public Pet getPetByName() throws IOException {
        if (pets.size() == 0) {
            System.out.println("Client Has No Pets");
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Pet's Name");
        String petName = reader.readLine();
        for (Pet p : this.pets) {
            if (p.getName().equals(petName))
                return p;
        }
        System.out.println("Client Has No Pet With This Name!!!");
        return null;
    }
    /**
     * print client's pets on console
     */
    public void printPets() {
        for (Pet p : pets) {
            System.out.println(p.getName());
        }
    }


    public Pet addPetToClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Set Type Of Pet (1 - Cat / 2 - Dog) :");
        int typeOfPet = Integer.parseInt(reader.readLine());
        Pet newPet = createPet(typeOfPet);
        if (newPet != null)
            this.pets.add(newPet);
        return newPet;
    }
    public Pet createPet(int typeOfPet) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (typeOfPet != 1 && typeOfPet != 2) {
            System.out.println("Wrong Choices Type Of Pet!!!");
            return null;
        } else {
            System.out.println("Enter Pet's Name");
            String petName = reader.readLine();
            if (typeOfPet == 1)
                return new Cat(petName);
            else
                return new Dog(petName);
        }
    }


    /**
     * remove one clients pet
     *
     * @param petName
     * @return
     */
    public boolean removePet(String petName) {
        for (Pet p : pets) {
            if (p.getName().equals(petName)) {
                pets.remove(p);
                System.out.println(petName + " Was Removed!");
                return true;
            }
        }
        System.out.println("Client Has No Pet With This Name!!!");
        return false;
    }




}
