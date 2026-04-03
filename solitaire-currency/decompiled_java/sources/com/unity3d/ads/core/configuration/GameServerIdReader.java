package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GameServerIdReader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GameServerIdReader extends MetadataReader<String> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String PLAYER_SERVER_ID_KEY = "player.server_id.value";

    /* JADX INFO: compiled from: GameServerIdReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameServerIdReader(@NotNull JsonStorage jsonStorage) {
        super(jsonStorage, PLAYER_SERVER_ID_KEY);
        t.i(jsonStorage, "jsonStorage");
    }
}
