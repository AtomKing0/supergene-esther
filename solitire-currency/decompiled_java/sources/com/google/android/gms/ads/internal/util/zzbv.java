package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfvh;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import com.unity3d.services.UnityAdsConstants;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbv {
    public static Point zza(MotionEvent motionEvent, @Nullable View view) {
        int[] iArrZzj = zzj(view);
        return new Point(((int) motionEvent.getRawX()) - iArrZzj[0], ((int) motionEvent.getRawY()) - iArrZzj[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhj)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(@Nullable String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(ViewHierarchyNode.JsonKeys.X, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, point2.x));
                jSONObject3.put(ViewHierarchyNode.JsonKeys.Y, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, point2.y));
                jSONObject3.put("start_x", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, point.x));
                jSONObject3.put("start_y", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, point.y));
                jSONObject2 = jSONObject3;
            } catch (JSONException e11) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while putting signals into JSON object.", e11);
            }
            jSONObject.put("click_point", jSONObject2);
            jSONObject.put("asset_id", str);
            return jSONObject;
        } catch (Exception e12) {
            e = e12;
            jSONObject2 = jSONObject;
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject2;
        }
    }

    public static JSONObject zzd(Context context, @Nullable Map map, @Nullable Map map2, @Nullable View view, @Nullable ImageView.ScaleType scaleType) {
        String str;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject3 = new JSONObject();
        if (map != null && view != null) {
            int[] iArrZzj = zzj(view);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] iArrZzj2 = zzj(view2);
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    Iterator it2 = it;
                    try {
                        JSONObject jSONObject6 = jSONObject3;
                        try {
                            jSONObject5.put("width", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, view2.getMeasuredWidth()));
                            jSONObject5.put("height", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, view2.getMeasuredHeight()));
                            jSONObject5.put(ViewHierarchyNode.JsonKeys.X, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, iArrZzj2[0] - iArrZzj[0]));
                            jSONObject5.put(ViewHierarchyNode.JsonKeys.Y, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, iArrZzj2[1] - iArrZzj[1]));
                            jSONObject5.put(str4, str3);
                            jSONObject4.put(TypedValues.AttributesType.S_FRAME, jSONObject5);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject2 = zzk(context, rect);
                            } else {
                                jSONObject2 = new JSONObject();
                                jSONObject2.put("width", 0);
                                jSONObject2.put("height", 0);
                                jSONObject2.put(ViewHierarchyNode.JsonKeys.X, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, iArrZzj2[0] - iArrZzj[0]));
                                jSONObject2.put(ViewHierarchyNode.JsonKeys.Y, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, iArrZzj2[1] - iArrZzj[1]));
                                jSONObject2.put(str4, str3);
                            }
                            jSONObject4.put("visible_bounds", jSONObject2);
                            if (((String) entry.getKey()).equals("3010")) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhe)).booleanValue()) {
                                    jSONObject4.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhf)).booleanValue()) {
                                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                    jSONObject4.put("view_width_layout_type", zzl(layoutParams.width) - 1);
                                    jSONObject4.put("view_height_layout_type", zzl(layoutParams.height) - 1);
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhg)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject4.put("view_path", TextUtils.join(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject4.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject4.put(NotificationSchedulerKeys.KEY_TEXT_COLOR, textView.getCurrentTextColor());
                                str = str3;
                                str2 = str4;
                                try {
                                    jSONObject4.put("font_size", textView.getTextSize());
                                    jSONObject4.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    jSONObject = jSONObject6;
                                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to get asset views information");
                                    it = it2;
                                    jSONObject3 = jSONObject;
                                    str3 = str;
                                    str4 = str2;
                                }
                            } else {
                                str = str3;
                                str2 = str4;
                            }
                            jSONObject4.put("is_clickable", map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable());
                            jSONObject = jSONObject6;
                        } catch (JSONException unused2) {
                            str = str3;
                            str2 = str4;
                        }
                    } catch (JSONException unused3) {
                        str = str3;
                        str2 = str4;
                        jSONObject = jSONObject3;
                    }
                    try {
                        jSONObject.put((String) entry.getKey(), jSONObject4);
                    } catch (JSONException unused4) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to get asset views information");
                    }
                    it = it2;
                    jSONObject3 = jSONObject;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject3;
    }

    public static JSONObject zze(Context context, @Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                com.google.android.gms.ads.internal.zzu.zzp();
                jSONObject.put("can_show_on_lock_screen", zzt.zzn(view));
                com.google.android.gms.ads.internal.zzu.zzp();
                jSONObject.put("is_keyguard_locked", zzt.zzD(context));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject zzf(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhd)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzu.zzp();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    if (parent != null) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                } else {
                    com.google.android.gms.ads.internal.zzu.zzp();
                    ViewParent parent2 = view.getParent();
                    while (parent2 != null && !(parent2 instanceof AdapterView)) {
                        parent2 = parent2.getParent();
                    }
                    jSONObject.put("contained_in_scroll_view", (parent2 == null ? -1 : ((AdapterView) parent2).getPositionForView(view)) != -1);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015f A[Catch: JSONException -> 0x0164, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0164, blocks: (B:29:0x012b, B:46:0x0156, B:47:0x015a, B:48:0x015f), top: B:62:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject zzg(android.content.Context r16, @androidx.annotation.Nullable android.view.View r17) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbv.zzg(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean zzh(Context context, zzfel zzfelVar) {
        if (!zzfelVar.zzN) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhh)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhk)).booleanValue();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhi);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            Iterator it = zzfvh.zzb(zzfui.zzc(';')).zzc(str).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzi(int i10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdd)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzde)).booleanValue() || i10 <= 15299999;
        }
        return true;
    }

    public static int[] zzj(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put(ViewHierarchyNode.JsonKeys.X, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, rect.left));
        jSONObject.put(ViewHierarchyNode.JsonKeys.Y, com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int zzl(int i10) {
        if (i10 != -2) {
            return i10 != -1 ? 2 : 3;
        }
        return 4;
    }
}
