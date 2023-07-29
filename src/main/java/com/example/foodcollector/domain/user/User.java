package com.example.foodcollector.domain.user;

import com.example.foodcollector.domain.task.Task;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @CollectionTable(name = "users_tasks")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<Task> task;
}
