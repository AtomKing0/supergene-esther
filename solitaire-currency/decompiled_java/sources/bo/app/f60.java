package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f60 implements n00 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2772e = BrazeLogger.getBrazeLogTag((Class<?>) f60.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g60 f2773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2776d;

    public f60(g60 g60Var, String str, int i10) {
        this.f2773a = g60Var;
        this.f2774b = str;
        this.f2775c = i10;
    }

    public final boolean a(Object obj) {
        if (!(obj instanceof String)) {
            int i10 = this.f2775c;
            return i10 == 2 || i10 == 17;
        }
        int i11 = this.f2775c;
        if (i11 == 1) {
            return obj.equals(this.f2776d);
        }
        if (i11 == 2) {
            return !obj.equals(this.f2776d);
        }
        if (i11 == 10) {
            return Pattern.compile((String) this.f2776d, 2).matcher((String) obj).find();
        }
        if (i11 != 17) {
            return false;
        }
        return !Pattern.compile((String) this.f2776d, 2).matcher((String) obj).find();
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.f2773a.equals(g60.UNKNOWN)) {
                jSONObject.put("property_type", this.f2773a.toString());
            }
            jSONObject.put("property_key", this.f2774b);
            jSONObject.put("comparator", this.f2775c);
            jSONObject.put("property_value", this.f2776d);
        } catch (JSONException e10) {
            BrazeLogger.e(f2772e, "Caught exception creating property filter Json.", e10);
        }
        return jSONObject;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f60(JSONObject jSONObject) {
        g60 g60Var = (g60) JsonUtils.optEnum(jSONObject, "property_type", g60.class, g60.UNKNOWN);
        this(g60Var, jSONObject.getString("property_key"), jSONObject.getInt("comparator"));
        if (jSONObject.has("property_value")) {
            if (g60Var.equals(g60.STRING)) {
                this.f2776d = jSONObject.getString("property_value");
                return;
            }
            if (g60Var.equals(g60.BOOLEAN)) {
                this.f2776d = Boolean.valueOf(jSONObject.getBoolean("property_value"));
            } else if (g60Var.equals(g60.NUMBER)) {
                this.f2776d = Double.valueOf(jSONObject.getDouble("property_value"));
            } else if (g60Var.equals(g60.DATE)) {
                this.f2776d = Long.valueOf(jSONObject.getLong("property_value"));
            }
        }
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        Object objOpt;
        if (!(g10Var instanceof i10)) {
            return false;
        }
        BrazeProperties brazeProperties = ((ye0) ((i10) g10Var)).f4356e;
        Date date = null;
        if (brazeProperties != null) {
            try {
                objOpt = brazeProperties.forJsonPut().opt(this.f2774b);
            } catch (Exception e10) {
                BrazeLogger.e(f2772e, "Caught exception checking property filter condition.", e10);
                return false;
            }
        } else {
            objOpt = null;
        }
        if (objOpt == null) {
            int i10 = this.f2775c;
            return i10 == 12 || i10 == 17 || i10 == 2;
        }
        int i11 = this.f2775c;
        if (i11 == 11) {
            return true;
        }
        if (i11 == 12) {
            return false;
        }
        int iOrdinal = this.f2773a.ordinal();
        if (iOrdinal == 0) {
            return a(objOpt);
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    return false;
                }
                if (!(objOpt instanceof Boolean)) {
                    return this.f2775c == 2;
                }
                int i12 = this.f2775c;
                if (i12 == 1) {
                    return objOpt.equals(this.f2776d);
                }
                if (i12 != 2) {
                    return false;
                }
                return !objOpt.equals(this.f2776d);
            }
            if (!(objOpt instanceof Integer) && !(objOpt instanceof Double)) {
                if (this.f2775c != 2) {
                    return false;
                }
            } else {
                double dDoubleValue = ((Number) objOpt).doubleValue();
                double dDoubleValue2 = ((Number) this.f2776d).doubleValue();
                int i13 = this.f2775c;
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 5 || dDoubleValue >= dDoubleValue2) {
                                return false;
                            }
                        } else if (dDoubleValue <= dDoubleValue2) {
                            return false;
                        }
                    } else if (dDoubleValue == dDoubleValue2) {
                        return false;
                    }
                } else if (dDoubleValue != dDoubleValue2) {
                    return false;
                }
            }
            return true;
        }
        long j10 = ((we0) g10Var).f4201a;
        if (objOpt instanceof String) {
            try {
                date = DateTimeUtils.parseDate((String) objOpt, BrazeDateFormat.LONG);
            } catch (Exception e11) {
                BrazeLogger.e(f2772e, "Caught exception trying to parse date in compareTimestamps", e11);
            }
        }
        if (date == null) {
            if (this.f2775c != 2) {
                return false;
            }
        } else {
            long timeFromEpochInSeconds = DateTimeUtils.getTimeFromEpochInSeconds(date);
            long jLongValue = ((Number) this.f2776d).longValue();
            int i14 = this.f2775c;
            if (i14 != 15) {
                if (i14 != 16) {
                    switch (i14) {
                        case 1:
                            if (timeFromEpochInSeconds != jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        case 2:
                            if (timeFromEpochInSeconds == jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        case 3:
                            if (timeFromEpochInSeconds <= jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        case 4:
                            if (timeFromEpochInSeconds < j10 - jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        case 5:
                            if (timeFromEpochInSeconds >= jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        case 6:
                            if (timeFromEpochInSeconds > j10 - jLongValue) {
                                return false;
                            }
                            break;
                            break;
                        default:
                            return false;
                    }
                } else if (timeFromEpochInSeconds <= j10 + jLongValue) {
                    return false;
                }
            } else if (timeFromEpochInSeconds >= j10 + jLongValue) {
                return false;
            }
        }
        return true;
    }
}
