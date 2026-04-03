package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.C;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeds extends zzbsf {

    @VisibleForTesting
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsk zzc;
    private final com.google.android.gms.ads.internal.util.client.zzr zzd;
    private final zzedh zze;
    private String zzf;
    private String zzg;

    @VisibleForTesting
    public zzeds(Context context, zzedh zzedhVar, com.google.android.gms.ads.internal.util.client.zzr zzrVar, zzdsk zzdskVar) {
        this.zzb = context;
        this.zzc = zzdskVar;
        this.zzd = zzrVar;
        this.zze = zzedhVar;
    }

    public static void zzc(Context context, zzdsk zzdskVar, zzedh zzedhVar, String str, String str2) {
        zzd(context, zzdskVar, zzedhVar, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdsk zzdskVar, zzedh zzedhVar, String str, String str2, Map map) {
        String strZze;
        String str3 = true != com.google.android.gms.ads.internal.zzu.zzo().zzA(context) ? "offline" : "online";
        if (zzdskVar != null) {
            zzdsj zzdsjVarZza = zzdskVar.zza();
            zzdsjVarZza.zzb("gqi", str);
            zzdsjVarZza.zzb("action", str2);
            zzdsjVarZza.zzb("device_connectivity", str3);
            zzdsjVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzdsjVarZza.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            strZze = zzdsjVarZza.zze();
        } else {
            strZze = "";
        }
        zzedhVar.zzd(new zzedj(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis(), str, strZze, 2));
    }

    @VisibleForTesting
    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, AdService.CLASS_NAME);
            return zzfsg.zzb(context, 0, intent, zzfsg.zza | 1073741824, 0);
        }
        intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
        return zzfsg.zza(context, 0, intent, 201326592);
    }

    private final String zzs() {
        zzecz zzeczVar = (zzecz) this.zza.get(this.zzf);
        return zzeczVar == null ? "" : zzeczVar.zzb();
    }

    private static String zzt(int i10, String str) {
        Resources resourcesZze = com.google.android.gms.ads.internal.zzu.zzo().zze();
        return resourcesZze == null ? str : resourcesZze.getString(i10);
    }

    private final void zzu(String str, String str2, Map map) {
        zzd(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    private final void zzv() {
        boolean zZzg;
        try {
            com.google.android.gms.ads.internal.zzu.zzp();
            com.google.android.gms.ads.internal.util.zzbr zzbrVarZzz = com.google.android.gms.ads.internal.util.zzt.zzz(this.zzb);
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.zzb);
            String str = this.zzg;
            String str2 = this.zzf;
            zzecz zzeczVar = (zzecz) this.zza.get(str2);
            zZzg = zzbrVarZzz.zzg(iObjectWrapperWrap, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, zzeczVar == null ? "" : zzeczVar.zzc()));
            if (!zZzg) {
                try {
                    zZzg = zzbrVarZzz.zzf(ObjectWrapper.wrap(this.zzb), this.zzg, this.zzf);
                } catch (RemoteException e10) {
                    e = e10;
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("Failed to schedule offline notification poster.", e);
                }
            }
        } catch (RemoteException e11) {
            e = e11;
            zZzg = false;
        }
        if (zZzg) {
            return;
        }
        this.zze.zzc(this.zzf);
        zzu(this.zzf, "offline_notification_worker_not_scheduled", zzfxu.zzd());
    }

    private final void zzw(final Activity activity, @Nullable final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzu.zzp();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzv();
            zzx(activity, zzmVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzu(this.zzf, "asnpdi", zzfxu.zzd());
                return;
            }
            com.google.android.gms.ads.internal.zzu.zzp();
            AlertDialog.Builder builderZzK = com.google.android.gms.ads.internal.util.zzt.zzK(activity);
            builderZzK.setTitle(zzt(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzt(R.string.notifications_permission_confirm, "Allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedl
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.zza.zzk(activity, zzmVar, dialogInterface, i10);
                }
            }).setNegativeButton(zzt(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.zza.zzl(zzmVar, dialogInterface, i10);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedn
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.zza.zzm(zzmVar, dialogInterface);
                }
            });
            builderZzK.create().show();
            zzu(this.zzf, "rtsdi", zzfxu.zzd());
        }
    }

    private final void zzx(Activity activity, @Nullable final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        AlertDialog alertDialogCreate;
        com.google.android.gms.ads.internal.zzu.zzp();
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzt.zzK(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedk
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        int i10 = R.layout.offline_ads_dialog;
        Resources resourcesZze = com.google.android.gms.ads.internal.zzu.zzo().zze();
        XmlResourceParser layout = resourcesZze == null ? null : resourcesZze.getLayout(i10);
        if (layout == null) {
            onCancelListener.setMessage(zzt(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialogCreate = onCancelListener.create();
        } else {
            View viewInflate = activity.getLayoutInflater().inflate(layout, (ViewGroup) null);
            onCancelListener.setView(viewInflate);
            String strZzs = zzs();
            if (!strZzs.isEmpty()) {
                TextView textView = (TextView) viewInflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(strZzs);
            }
            zzecz zzeczVar = (zzecz) this.zza.get(this.zzf);
            Drawable drawableZza = zzeczVar != null ? zzeczVar.zza() : null;
            if (drawableZza != null) {
                ((ImageView) viewInflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawableZza);
            }
            alertDialogCreate = onCancelListener.create();
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialogCreate.show();
        Timer timer = new Timer();
        timer.schedule(new zzedr(this, alertDialogCreate, timer, zzmVar), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zZzA = com.google.android.gms.ads.internal.zzu.zzo().zzA(this.zzb);
            HashMap map = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                map.put("offline_notification_action", "offline_notification_clicked");
                c = true == zZzA ? (char) 1 : (char) 2;
                map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                map.put("olaih", String.valueOf(stringExtra3.startsWith(ProxyConfig.MATCH_HTTP)));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    map.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    map.put("olaa", "olaf");
                }
            } else {
                map.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzu(stringExtra2, "offline_notification_action", map);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzedh.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to get writable offline buffering database: ".concat(e10.toString()));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (strArr[i10].equals("android.permission.POST_NOTIFICATIONS")) {
                zzedu zzeduVar = (zzedu) ObjectWrapper.unwrap(iObjectWrapper);
                Activity activityZza = zzeduVar.zza();
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzeduVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i10] == 0) {
                    map.put("dialog_action", "confirm");
                    zzv();
                    zzx(activityZza, zzmVarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzmVarZzb != null) {
                        zzmVarZzb.zzb();
                    }
                }
                zzu(this.zzf, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzedu zzeduVar = (zzedu) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity activityZza = zzeduVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzeduVar.zzb();
        this.zzf = zzeduVar.zzc();
        this.zzg = zzeduVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhF)).booleanValue()) {
            zzw(activityZza, zzmVarZzb);
            return;
        }
        zzu(this.zzf, "dialog_impression", zzfxu.zzd());
        com.google.android.gms.ads.internal.zzu.zzp();
        AlertDialog.Builder builderZzK = com.google.android.gms.ads.internal.util.zzt.zzK(activityZza);
        builderZzK.setTitle(zzt(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzt(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzt(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.zza.zzn(activityZza, zzmVarZzb, dialogInterface, i10);
            }
        }).setNegativeButton(zzt(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.zza.zzo(zzmVarZzb, dialogInterface, i10);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzp(zzmVarZzb, dialogInterface);
            }
        });
        builderZzK.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzh() {
        final com.google.android.gms.ads.internal.util.client.zzr zzrVar = this.zzd;
        this.zze.zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzeda
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) throws Exception {
                zzedh.zzb(zzrVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Bitmap bitmapDecodeStream;
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str2 = zzaVar.zza;
        String str3 = zzaVar.zzb;
        String str4 = zzaVar.zzc;
        String strZzs = zzs();
        com.google.android.gms.ads.internal.zzu.zzq().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        PendingIntent pendingIntentZzr = zzr(context, "offline_notification_clicked", str3, str2);
        PendingIntent pendingIntentZzr2 = zzr(context, "offline_notification_dismissed", str3, str2);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (strZzs.isEmpty()) {
            builder.setContentTitle(zzt(R.string.offline_notification_title, "You are back online! Let's pick up where we left off"));
        } else {
            builder.setContentTitle(String.format(zzt(R.string.offline_notification_title_with_advertiser, "You are back online! Continue learning about %s"), strZzs));
        }
        builder.setAutoCancel(true).setDeleteIntent(pendingIntentZzr2).setContentIntent(pendingIntentZzr).setSmallIcon(context.getApplicationInfo().icon).setPriority(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhG)).intValue());
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhI)).booleanValue() || str4.isEmpty()) {
            bitmapDecodeStream = null;
        } else {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str4).openConnection().getInputStream());
            } catch (IOException unused) {
                bitmapDecodeStream = null;
            }
        }
        if (bitmapDecodeStream != null) {
            try {
                builder.setLargeIcon(bitmapDecodeStream).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapDecodeStream).bigLargeIcon((Bitmap) null));
            } catch (Resources.NotFoundException unused2) {
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap map = new HashMap();
        try {
            notificationManager.notify(str3, 54321, builder.build());
            str = "offline_notification_impression";
        } catch (IllegalArgumentException e10) {
            map.put("notification_not_shown_reason", e10.getMessage());
            str = "offline_notification_failed";
        }
        zzu(str3, str, map);
    }

    final /* synthetic */ void zzk(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i10) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzu(this.zzf, "rtsdc", map);
        activity.startActivity(com.google.android.gms.ads.internal.zzu.zzq().zzf(activity));
        zzv();
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzl(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i10) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzm(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzn(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i10) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzu(this.zzf, "dialog_click", map);
        zzw(activity, zzmVar);
    }

    final /* synthetic */ void zzo(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i10) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzp(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public final void zzq(String str, zzdjb zzdjbVar) {
        String string = "";
        String strZzx = !TextUtils.isEmpty(zzdjbVar.zzx()) ? zzdjbVar.zzx() : zzdjbVar.zzB() != null ? zzdjbVar.zzB() : "";
        zzbfd zzbfdVarZzm = zzdjbVar.zzm();
        if (zzbfdVarZzm != null) {
            try {
                string = zzbfdVarZzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbfd zzbfdVarZzn = zzdjbVar.zzn();
        Drawable drawable = null;
        if (zzbfdVarZzn != null) {
            try {
                IObjectWrapper iObjectWrapperZzf = zzbfdVarZzn.zzf();
                if (iObjectWrapperZzf != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzecv(strZzx, string, drawable));
    }
}
