package kotlin.reflect;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KDeclarationContainer.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KDeclarationContainer {
    @NotNull
    Collection<KCallable<?>> getMembers();
}
