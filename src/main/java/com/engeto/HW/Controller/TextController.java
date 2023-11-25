package com.engeto.HW.Controller;

import com.engeto.HW.Settings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@RestController()
@RequestMapping("/texts")
public class TextController {
    @GetMapping("/scifi")
    public String printScifi(){
        return loadFromFile(Settings.FilenameScifi());
    }

    @GetMapping("/romantic")
    public String printRomantic(){
        return loadFromFile(Settings.FilenameRomantic());
    }

    @GetMapping("/historic")
    public String printHistoric(){
        return loadFromFile(Settings.FilenameHistoric());
    }

    public static String loadFromFile(String filename){
        String line = "";
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            line = scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println("Nastala chyba při čtení ze souboru "+filename+e.getLocalizedMessage());
        }
        return line;
    }
}
