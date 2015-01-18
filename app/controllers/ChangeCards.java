package controllers;

import models.forms.ChangeCard;
import play.data.validation.Valid;
import play.mvc.Controller;

public class ChangeCards extends Controller {
	
	public static void index(ChangeCard changeCard) {
		if (changeCard == null) {
			changeCard = new ChangeCard();
		}
		changeCard.brandId = "fdsf";
		render(changeCard);
	}

	public static void confirm(@Valid ChangeCard changeCard) {
		if (validation.hasErrors()) {
			System.out.println(validation.errors());
			index(changeCard);
		}
		render(changeCard);
	}
}
