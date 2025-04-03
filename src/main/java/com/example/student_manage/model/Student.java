// package com.example.student_manage.model;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

// @Document(collection = "student") // Collection name in MongoDB
// public class Student {

//     @Id
//     private String id;
//     private String name;
//     private String email;

//     // Constructors
//     public Student() {}

//     public Student(String name, String email) {
//         this.name = name;
//         this.email = email;
//     }
//     //sjhshshsh

//     // Getters and Setters
//     public String getId() { return id; }
//     public void setId(String id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
// }



package com.example.student_manage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "student") // Collection name in MongoDB
public class Student {

    @Id
    private String id;
    private String name;
    private String email;
    private List<String> modules = new ArrayList<>(); // ✅ Added a list to store multiple modules

    // Constructors
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getModules() { return modules; }
    public void setModules(List<String> modules) { this.modules = modules; }

    public void registerModule(String moduleCode) {
        this.modules.add(moduleCode); // ✅ Add module to the list
    }
}

