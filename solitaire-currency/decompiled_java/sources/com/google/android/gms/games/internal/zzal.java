package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzal extends com.google.android.gms.internal.games_v2.zzb implements zzam {
    public zzal() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    @Override // com.google.android.gms.internal.games_v2.zzb
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 6001 || i10 == 6002) {
            parcel.readString();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i10 == 12011) {
            DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
            zzd(dataHolder);
        } else if (i10 == 12012) {
            int i12 = parcel.readInt();
            String string = parcel.readString();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
            zzp(i12, string);
        } else if (i10 == 13001) {
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i10 == 13002) {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i10 == 19001) {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i10 != 19002) {
            switch (i10) {
                case 5001:
                    parcel.readInt();
                    parcel.readString();
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case 5002:
                    DataHolder dataHolder2 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzc(dataHolder2);
                    break;
                case 5003:
                    int i13 = parcel.readInt();
                    String string2 = parcel.readString();
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzb(i13, string2);
                    break;
                case IronSourceConstants.errorCode_showInProgress /* 5004 */:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzg(dataHolder3);
                    break;
                case IronSourceConstants.errorCode_loadException /* 5005 */:
                    Parcelable.Creator<DataHolder> creator = DataHolder.CREATOR;
                    DataHolder dataHolder4 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, creator);
                    DataHolder dataHolder5 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, creator);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzf(dataHolder4, dataHolder5);
                    break;
                case IronSourceConstants.errorCode_showFailed /* 5006 */:
                    DataHolder dataHolder6 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzk(dataHolder6);
                    break;
                case IronSourceConstants.errorCode_initSuccess /* 5007 */:
                    DataHolder dataHolder7 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzj(dataHolder7);
                    break;
                case IronSourceConstants.errorCode_initFailed /* 5008 */:
                    DataHolder dataHolder8 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zze(dataHolder8);
                    break;
                case IronSourceConstants.errorCode_adClosed /* 5009 */:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case IronSourceConstants.errorCode_destroy /* 5010 */:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case IronSourceConstants.errorCode_internal /* 5011 */:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                default:
                    switch (i10) {
                        case 5016:
                            zzm();
                            break;
                        case 5017:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5018:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5019:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5020:
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5021:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5022:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5023:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5024:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5025:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5026:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5027:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5028:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5029:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5030:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5031:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5032:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5033:
                            parcel.readInt();
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5034:
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5035:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5036:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5037:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5038:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5039:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5040:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case AdError.AD_PRESENTATION_ERROR_CODE /* 9001 */:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 11001:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 12001:
                            DataHolder dataHolder9 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzr(dataHolder9);
                            break;
                        case 14001:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 15001:
                            DataHolder dataHolder10 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzi(dataHolder10);
                            break;
                        case 17002:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19008:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19009:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19010:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case AD_SERVER_ERROR_VALUE:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20002:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20003:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20004:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20005:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20006:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20007:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20008:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20009:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20012:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20019:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20020:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23001:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23002:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23003:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23004:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23005:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 24002:
                            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 25002:
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 25003:
                            Status status = (Status) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Status.CREATOR);
                            String string3 = parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzl(status, string3);
                            break;
                        case 25004:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        default:
                            switch (i10) {
                                case 8001:
                                    DataHolder dataHolder11 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    zzh(dataHolder11);
                                    break;
                                case 8002:
                                    parcel.readInt();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8003:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8004:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8005:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8006:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8007:
                                    parcel.readInt();
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8008:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8009:
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8010:
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                default:
                                    switch (i10) {
                                        case 10001:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case 10002:
                                            parcel.readString();
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case 10003:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /* 10004 */:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case 10005:
                                            parcel.readInt();
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /* 10006 */:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        default:
                                            switch (i10) {
                                                case 12004:
                                                    DataHolder dataHolder12 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                    Contents contents = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Contents.CREATOR);
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    zzq(dataHolder12, contents);
                                                    break;
                                                case 12005:
                                                    DataHolder dataHolder13 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    zzn(dataHolder13);
                                                    break;
                                                case 12006:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                case 12007:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                case 12008:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                default:
                                                    switch (i10) {
                                                        case 12014:
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12015:
                                                            parcel.readInt();
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12016:
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12017:
                                                            DataHolder dataHolder14 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                            String string4 = parcel.readString();
                                                            Parcelable.Creator<Contents> creator2 = Contents.CREATOR;
                                                            Contents contents2 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, creator2);
                                                            Contents contents3 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, creator2);
                                                            Contents contents4 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, creator2);
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            zzo(dataHolder14, string4, contents2, contents3, contents4);
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        }
        parcel2.writeNoException();
        return true;
    }
}
