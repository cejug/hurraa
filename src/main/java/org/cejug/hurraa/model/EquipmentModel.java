package org.cejug.hurraa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.cejug.hurraa.validation.EquipmentModelNameAvailable;
import org.hibernate.validator.constraints.NotBlank;

@NamedQuery(name = "FIND_BY_NAME" , query = "FROM EquipmentModel e WHERE e.name = :name" )
@Entity
public class EquipmentModel {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @EquipmentModelNameAvailable
    @Column(nullable = false , unique = true)
    private String name;
    
    @NotNull
    @ManyToOne(optional = false)
    private EquipmentType equipmentType;
    
    public EquipmentModel() {    }
    
    public EquipmentModel(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EquipmentModel other = (EquipmentModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
    
}
