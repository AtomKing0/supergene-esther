package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.applovin.sdk.AppLovinEventTypes;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BatteryNotLowTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryNotLowTracker(@NotNull Context context, @NotNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.i(context, "context");
        t.i(taskExecutor, "taskExecutor");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    @NotNull
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(@NotNull Intent intent) {
        t.i(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        Logger.get().debug(BatteryNotLowTrackerKt.TAG, "Received " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1980154005) {
                if (action.equals("android.intent.action.BATTERY_OKAY")) {
                    setState(Boolean.TRUE);
                }
            } else if (iHashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                setState(Boolean.FALSE);
            }
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    @NotNull
    public Boolean readSystemState() {
        Intent intentRegisterReceiver = getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            Logger.get().error(BatteryNotLowTrackerKt.TAG, "getInitialState - null intent received");
            return Boolean.FALSE;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        float intExtra2 = intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) / intentRegisterReceiver.getIntExtra("scale", -1);
        boolean z10 = true;
        if (intExtra != 1 && intExtra2 <= 0.15f) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
