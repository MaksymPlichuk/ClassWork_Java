package org.example.Instrument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {
    private String name;
    private String description;
    private int yearsOld;
    private String history;

    public void Sound() {
        System.out.println("some sound");
    }
    public void Show() {
        System.out.println("Name: "+name);
    }
    public void Desc() {
        System.out.println("Desc: "+description);
    }
    public void History() {
        System.out.println("History: "+history);
    }
}
