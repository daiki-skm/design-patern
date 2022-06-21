public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {
    }

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
        if (12 <= hour && hour < 13) {
            context.changeState(NoonState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("非常：金庫使用（夜間）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル（夜間）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("夜間の通話録音");
    }

    @Override
    public String toString() {
        return "夜間";
    }
}