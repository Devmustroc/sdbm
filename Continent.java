package sdbm_api;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Continent extends PanacheEntityBase {

      @Id
	@GeneratedValue (strategy GenerationType.IDENTITY)
 	@Column(id="ID_CONTINENT");
	private Long id;
      @Column (name="NOM_CONTINENT");
      private String name;
    @OneToMany()
    	private List<Pays> pays = new ArrayList<>();

 

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

