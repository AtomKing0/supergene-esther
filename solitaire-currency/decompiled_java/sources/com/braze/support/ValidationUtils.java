package com.braze.support;

import bo.app.ei0;
import bo.app.fi0;
import bo.app.gi0;
import bo.app.hi0;
import bo.app.ii0;
import bo.app.ji0;
import bo.app.ki0;
import bo.app.li0;
import bo.app.mi0;
import bo.app.ni0;
import bo.app.oi0;
import bo.app.pi0;
import bo.app.vb0;
import com.braze.support.BrazeLogger;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.z0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import p9.q;
import p9.r;

/* JADX INFO: loaded from: classes2.dex */
public final class ValidationUtils {
    public static final ValidationUtils INSTANCE = new ValidationUtils();
    private static final Set<String> VALID_CURRENCY_CODES = z0.h("AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL");
    private static final p9.f EMAIL_ADDRESS_REGEX = new p9.f(".+@.+\\..+");
    private static final p9.f PHONE_NUMBER_REGEX = new p9.f("^[0-9 .\\(\\)\\+\\-]+$");

    private ValidationUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4, types: [T, java.lang.String] */
    public static final String ensureBrazeFieldLength(String str) {
        if (str == null || q.z(str)) {
            return "";
        }
        n0 n0Var = new n0();
        ?? string = r.b1(str).toString();
        n0Var.f29834a = string;
        if (string.length() > 255) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ei0(n0Var), 6, (Object) null);
            ?? Substring = ((String) n0Var.f29834a).substring(0, 255);
            t.h(Substring, "this as java.lang.String…ing(startIndex, endIndex)");
            n0Var.f29834a = Substring;
        }
        return (String) n0Var.f29834a;
    }

    public static final boolean isValidEmailAddress(String str) {
        if (str == null || str.length() == 0 || str.length() > 255) {
            return false;
        }
        return EMAIL_ADDRESS_REGEX.a(str);
    }

    public static final boolean isValidLocation(double d10, double d11) {
        return d10 < 90.0d && d10 > -90.0d && d11 < 180.0d && d11 > -180.0d;
    }

    public static final boolean isValidLogCustomEventInput(String str, vb0 serverConfigStorageProvider) {
        t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        if (str == null || q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) fi0.f2830a, 6, (Object) null);
            return false;
        }
        if (!serverConfigStorageProvider.b().contains(str)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new gi0(str), 6, (Object) null);
        return false;
    }

    public static final boolean isValidLogPurchaseInput(String str, String str2, BigDecimal bigDecimal, int i10, vb0 serverConfigStorageProvider) {
        t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        if (str == null || q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) hi0.f2984a, 6, (Object) null);
            return false;
        }
        if (serverConfigStorageProvider.c().contains(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ii0(str), 6, (Object) null);
            return false;
        }
        if (str2 == null || q.z(str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ji0.f3162a, 6, (Object) null);
            return false;
        }
        Set<String> set = VALID_CURRENCY_CODES;
        String string = r.b1(str2).toString();
        Locale US = Locale.US;
        t.h(US, "US");
        String upperCase = string.toUpperCase(US);
        t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        if (!set.contains(upperCase)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ki0(str2), 6, (Object) null);
            return false;
        }
        if (bigDecimal == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) li0.f3338a, 6, (Object) null);
            return false;
        }
        if (i10 <= 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new mi0(i10), 6, (Object) null);
            return false;
        }
        if (i10 <= 100) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ni0(i10), 6, (Object) null);
        return false;
    }

    public static final boolean isValidPhoneNumber(String str) {
        return str != null && PHONE_NUMBER_REGEX.a(str);
    }

    public static final boolean isValidPushStoryClickInput(String str, String str2) {
        if (str == null || q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) oi0.f3568a, 6, (Object) null);
            return false;
        }
        if (str2 != null && !q.z(str2)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) pi0.f3632a, 6, (Object) null);
        return false;
    }

    public final Set<String> getVALID_CURRENCY_CODES() {
        return VALID_CURRENCY_CODES;
    }
}
