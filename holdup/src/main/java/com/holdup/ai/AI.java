package com.holdup.ai;

import com.holdup.card.Card;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PiegeCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.SilencieuxCard;
import com.holdup.player.Player;

public interface AI {
	Card chooseCard(Player player);
	void configure(SilencieuxCard card);
	void configure(PorteVoixCard card);
	void configure(PanierDePartageCard card);
	void configure(MatraqueCard card);
	void configure(GadgetDeDistractionCard card);
	void configure(DeuxPistoletCard card);
	void configure(CouteauCard card);
	void configure(PiegeCard card);
}
