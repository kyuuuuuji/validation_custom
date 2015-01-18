package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Card extends Model {

	@Column
	public String no;

	@Column
	public String brand_id;

	public static boolean existsInBrand(String no, String brandId) {
		// ブランド内で一意なカード的な
		List<Card> card = Card.find("select card from Card card "
				+ "where card.brand_id like ? "
				+ "and card.no like ?", brandId, no).fetch();
		return card.size() != 0;
	}
}