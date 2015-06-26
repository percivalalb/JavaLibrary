package javalibrary.fitness;

public class StatisticRange {

	public StatisticType type;
	public double value;
	public double standardDeviation;
	
	public StatisticRange(StatisticType type, double value, double standardDeviation) {
		this.type = type;
		this.value = value;
		this.standardDeviation = standardDeviation;
	}
}