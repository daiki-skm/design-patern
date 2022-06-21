public class NoonState implements State {
    private static NoonState singleton = new NoonState();

    private NoonState() {
    }

    public static NoonState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
        if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("非常：金庫使用（昼食）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常：非常ベル");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通話録音（昼食）");
    }

    @Override
    public String toString() {
        return "昼食";
    }
}