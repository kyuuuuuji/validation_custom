package models.forms;


import models.Brand;
import models.Card;
import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.MinSize;
import play.data.validation.Required;

public class ChangeCard {

	@CheckWith(CardNoValidation.class)
	@MinSize(value = 5)
	public String cardNo;

	@Required
	public String brandId;

	public class CardNoValidation extends Check {

		@Override
		public boolean isSatisfied(Object changeCard, Object cardNo) {
			ChangeCard validCard = (ChangeCard) changeCard;
			// 必須チェック
			if (cardNo == null || cardNo.toString().trim().length() <= 0) {
				setMessage("validation.required");
				return false;
			}

			// 重複チェック
			if (cardNo instanceof String && Card.existsInBrand((String) cardNo, validCard.brandId)) {
				setMessage("validation.exists");
				return false;
			}
			return true;
		}
	}
}
