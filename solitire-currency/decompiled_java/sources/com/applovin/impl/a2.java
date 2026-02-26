package com.applovin.impl;

import android.net.Uri;
import android.text.format.Formatter;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a2 {
    public static Map a(com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap();
        if (bVar == null) {
            return map;
        }
        com.applovin.impl.sdk.j sdk = bVar.getSdk();
        if (((Boolean) sdk.a(l4.J)).booleanValue()) {
            HashMap map2 = new HashMap();
            Iterator it = bVar.i().iterator();
            while (it.hasNext()) {
                String path = ((Uri) it.next()).getPath();
                map2.put(path, Formatter.formatFileSize(com.applovin.impl.sdk.j.n(), new File(path).length()));
            }
            map.put("path", map2.toString());
        }
        if ((bVar instanceof com.applovin.impl.sdk.ad.a) && ((Boolean) sdk.a(l4.K)).booleanValue()) {
            map.put("details", ((com.applovin.impl.sdk.ad.a) bVar).f1());
        }
        return map;
    }

    public static Map b(com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap(10);
        if (bVar == null) {
            return map;
        }
        CollectionUtils.putStringIfValid("ad_domain", bVar.getAdDomain(), map);
        CollectionUtils.putStringIfValid("ad_id", String.valueOf(bVar.getAdIdNumber()), map);
        MaxAdFormat maxAdFormatD = bVar.getAdZone().d();
        CollectionUtils.putStringIfValid("ad_format", maxAdFormatD != null ? maxAdFormatD.getLabel() : null, map);
        CollectionUtils.putStringIfValid("ad_zone_id", bVar.getAdZone().e(), map);
        CollectionUtils.putStringIfValid("clcode", bVar.getClCode(), map);
        CollectionUtils.putStringIfValid("dsp_id", bVar.getDspId(), map);
        CollectionUtils.putStringIfValid("dsp_name", bVar.getDspName(), map);
        CollectionUtils.putStringIfValid("ad_size", bVar.getSize().getLabel(), map);
        CollectionUtils.putStringIfValid("is_persisted_ad", String.valueOf(bVar.D0()), map);
        CollectionUtils.putStringIfValid("is_omsdk_enabled", String.valueOf(bVar.isOpenMeasurementEnabled()), map);
        return map;
    }

    public static Map a(q2 q2Var) {
        Map mapA = a((a3) q2Var);
        CollectionUtils.putStringIfValid("bcode", q2Var.C(), mapA);
        CollectionUtils.putStringIfValid("creative_id", q2Var.getCreativeId(), mapA);
        CollectionUtils.putStringIfValid("ad_unit_id", q2Var.getAdUnitId(), mapA);
        CollectionUtils.putStringIfValid("ad_format", q2Var.getFormat().getLabel(), mapA);
        return mapA;
    }

    public static Map a(a3 a3Var) {
        HashMap map = new HashMap(3);
        CollectionUtils.putStringIfValid("network_name", a3Var.c(), map);
        String strB = a3Var.b();
        CollectionUtils.putStringIfValid("adapter_class", strB, map);
        CollectionUtils.putStringIfValid("adapter_version", l3.a(strB).getAdapterVersion(), map);
        return map;
    }

    public static Map a(MaxError maxError) {
        HashMap map = new HashMap(4);
        CollectionUtils.putStringIfValid("error_message", maxError.getMessage(), map);
        CollectionUtils.putStringIfValid("error_code", String.valueOf(maxError.getCode()), map);
        CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), map);
        CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), map);
        return map;
    }

    public static String a(String str) {
        return StringUtils.prefixToIndex(1000, str);
    }
}
