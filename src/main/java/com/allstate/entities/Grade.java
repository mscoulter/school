package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "grades")
@Data
public class Grade {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @NotNull
    private int value;

    private boolean isPassing;

    @Column(name = "is_passing")
    @NotNull
    public boolean isPassing() { return isPassing; }
    public void setPassing(boolean passing) { isPassing = passing; }

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="klass_id")
    private Klass klass;

    public Grade() {
    }

    public Grade(int value, boolean isPassing, Student student, Klass klass) {
        this.value = value;
        this.isPassing = isPassing;
        this.student = student;
        this.klass = klass;
    }
}
