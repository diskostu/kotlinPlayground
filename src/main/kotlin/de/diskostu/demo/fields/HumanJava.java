package de.diskostu.demo.fields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanJava {

    private String name;


    public String getName() {
        return name;
    }


    private List<String> myList = new ArrayList<String>();


    public List<String> getMyList() {
        return Collections.unmodifiableList(myList);
    }


    public static void main(String[] args) {
        final HumanJava humanJava = new HumanJava();

        humanJava.getMyList().add("dsfsdf");
    }
}
