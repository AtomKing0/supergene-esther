package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import h9.l;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyMappingKt {

    @NotNull
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new g0() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.g0, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m2764isCtrlPressedZmokQxo(((KeyEvent) obj).m2749unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo672mapZmokQxo(@NotNull android.view.KeyEvent event) {
                t.i(event, "event");
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m2766isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m2764isCtrlPressedZmokQxo(event)) {
                    long jM2760getKeyZmokQxo = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m691getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m692getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m693getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m690getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m2764isCtrlPressedZmokQxo(event)) {
                    long jM2760getKeyZmokQxo2 = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m691getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m692getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m693getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m690getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m695getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m689getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m686getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m685getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m2766isShiftPressedZmokQxo(event)) {
                    long jM2760getKeyZmokQxo3 = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m698getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_HOME;
                    } else if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m697getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo672mapZmokQxo(event) : keyCommand;
            }
        };
    }

    @NotNull
    public static final KeyMapping commonKeyMapping(@NotNull final l<? super KeyEvent, Boolean> shortcutModifier) {
        t.i(shortcutModifier, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo672mapZmokQxo(@NotNull android.view.KeyEvent event) {
                t.i(event, "event");
                if (shortcutModifier.invoke(KeyEvent.m2743boximpl(event)).booleanValue() && KeyEvent_androidKt.m2766isShiftPressedZmokQxo(event)) {
                    if (Key.m2165equalsimpl0(KeyEvent_androidKt.m2760getKeyZmokQxo(event), MappedKeys.INSTANCE.m705getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (shortcutModifier.invoke(KeyEvent.m2743boximpl(event)).booleanValue()) {
                    long jM2760getKeyZmokQxo = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m687getCEK5gGoQ()) ? true : Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m696getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m703getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m704getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m684getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, mappedKeys.m705getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m2764isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m2766isShiftPressedZmokQxo(event)) {
                    long jM2760getKeyZmokQxo2 = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m691getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m692getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m693getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m690getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m700getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m699getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m698getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m697getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo2, mappedKeys2.m696getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM2760getKeyZmokQxo3 = KeyEvent_androidKt.m2760getKeyZmokQxo(event);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m691getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m692getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m693getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m690getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m700getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m699getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m698getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m697getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m694getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m686getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m689getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m701getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m688getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo3, mappedKeys3.m702getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    @NotNull
    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
