package bo.app;

import com.braze.support.JsonUtils;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f3989c;

    public u40(Integer num, Integer num2, Integer num3) {
        this.f3987a = num;
        this.f3988b = num2;
        this.f3989c = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u40)) {
            return false;
        }
        u40 u40Var = (u40) obj;
        return kotlin.jvm.internal.t.d(this.f3987a, u40Var.f3987a) && kotlin.jvm.internal.t.d(this.f3988b, u40Var.f3988b) && kotlin.jvm.internal.t.d(this.f3989c, u40Var.f3989c);
    }

    public final int hashCode() {
        Integer num = this.f3987a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f3988b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f3989c;
        return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        return "MessageButtonTheme(backgroundColor=" + this.f3987a + ", textColor=" + this.f3988b + ", borderColor=" + this.f3989c + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u40(JSONObject buttonThemeJson) {
        this(JsonUtils.getColorIntegerOrNull(buttonThemeJson, "bg_color"), JsonUtils.getColorIntegerOrNull(buttonThemeJson, NotificationSchedulerKeys.KEY_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(buttonThemeJson, "border_color"));
        kotlin.jvm.internal.t.i(buttonThemeJson, "buttonThemeJson");
    }
}
