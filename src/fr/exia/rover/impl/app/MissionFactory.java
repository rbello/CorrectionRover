package fr.exia.rover.impl.app;

import java.util.regex.Pattern;

import fr.exia.rover.contracts.IMission;
import fr.exia.rover.impl.missions.OrdersSequenceMission;
import fr.exia.rover.impl.missions.ReachLocationMission;

public class MissionFactory {

	public IMission parse(String sentence) {
		if (Pattern.matches("([fbrl][,]?)+", sentence)) {
			return new OrdersSequenceMission(sentence.split(","));
		}
		if (Pattern.matches("[0-9]+,[0-9]+", sentence)) {
			String[] tokens = sentence.split(",");
			return new ReachLocationMission(
					Integer.parseInt(tokens[0]),
					Integer.parseInt(tokens[1]));
		}
		return null;
	}

}
