package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Brand extends Model {
	
	@Required
	public String name;

	@OneToMany
	public List<Card> card;


}
