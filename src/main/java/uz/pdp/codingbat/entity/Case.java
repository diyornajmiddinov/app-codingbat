package uz.pdp.codingbat.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "text")
    private String args;

    @Column(nullable = false, columnDefinition = "text")
    private String expected;

    @ManyToOne(optional = false)
    private Problem problem;
}
