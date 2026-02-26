package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;
import com.ironsource.Cif;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "EventEntityCreator")
@SafeParcelable.Reserved({1000})
public final class EventEntity extends zzh implements Event {

    @NonNull
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();

    @SafeParcelable.Field(getter = "getEventId", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getDescription", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getIconImageUri", id = 4)
    private final Uri zzd;

    @SafeParcelable.Field(getter = "getIconImageUrl", id = 5)
    private final String zze;

    @SafeParcelable.Field(getter = "getPlayer", id = 6)
    private final PlayerEntity zzf;

    @SafeParcelable.Field(getter = "getValue", id = 7)
    private final long zzg;

    @SafeParcelable.Field(getter = "getFormattedValue", id = 8)
    private final String zzh;

    @SafeParcelable.Field(getter = Cif.f12602k, id = 9)
    private final boolean zzi;

    public EventEntity(@NonNull Event event) {
        this.zza = event.getEventId();
        this.zzb = event.getName();
        this.zzc = event.getDescription();
        this.zzd = event.getIconImageUri();
        this.zze = event.getIconImageUrl();
        this.zzf = (PlayerEntity) event.getPlayer().freeze();
        this.zzg = event.getValue();
        this.zzh = event.getFormattedValue();
        this.zzi = event.isVisible();
    }

    static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add(Cif.f12602k, Boolean.valueOf(event.isVisible())).toString();
    }

    static boolean zzc(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    public boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getDescription() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getEventId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getFormattedValue() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public Uri getIconImageUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getIconImageUrl() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public Player getPlayer() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.event.Event
    public long getValue() {
        return this.zzg;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean isVisible() {
        return this.zzi;
    }

    @NonNull
    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i10, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i10, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public void getFormattedValue(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzh, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public void getName(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @SafeParcelable.Constructor
    EventEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Player player, @SafeParcelable.Param(id = 7) long j10, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = uri;
        this.zze = str4;
        this.zzf = new PlayerEntity(player);
        this.zzg = j10;
        this.zzh = str5;
        this.zzi = z10;
    }
}
