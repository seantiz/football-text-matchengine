public class Fatigue {
    private int fatigueLevel = 0;

    public void gettingTired(int amount) {
    fatigueLevel += amount;
    if (fatigueLevel > 100) {
        fatigueLevel = 100;
    }
    
}

    public void gettingRefreshed(int amount) {
        fatigueLevel -= amount;
        if (fatigueLevel < 0) {
            fatigueLevel = 0;
        }
    }

    public String fatigueStatus() {
        if (fatigueLevel <= 25) {
            return "Fresh";
        } else if (fatigueLevel <= 50) {
            return "Tiring";
        }
        else if (fatigueLevel <= 75) {
            return "Tired";
        } else { 
            return "Needs Sub";
        }
    }

}


