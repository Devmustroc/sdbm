package sdbm_afpa;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pays extends PanacheEntityBase {

	@Id
	@GeneratedValue (strategy GenerationType.IDENTITY)
 	@Column(id="ID_PAYS");
	private Long id;
	@Column (name="NOM_PAYS");
 	private String name;
	@OneToMany()
    	private List<Marque> marques = new ArrayList<>();


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

