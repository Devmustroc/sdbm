package fr.shooterdev.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class TypeBiere extends PanacheEntityBase {

      @Id
	@GeneratedValue (strategy GenerationType.IDENTITY)
 	@Column(id="ID_TYPE");
	private Long id;
      @Column (name="NOM_TYPE");
      private String name;
    @OneToMany()
    	private List<Article> articles = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

