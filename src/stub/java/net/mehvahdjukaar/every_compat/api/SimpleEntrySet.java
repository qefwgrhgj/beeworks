package net.mehvahdjukaar.every_compat.api;

import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleEntrySet<T, B> {
    public static <T, B> Builder<T, B> builder(Class<T> clazz, String name, Object defaultBlock, Supplier<?> defaultType, Function<T, B> blockFactory) {
        return new Builder<>();
    }

    public static class Builder<T, B> {
        public Builder<T, B> addTile(Object tile) { return this; }
        public Builder<T, B> addTextureM(Object t1, Object t2) { return this; }
        public Builder<T, B> addTexture(Object t) { return this; }
        public Builder<T, B> addTag(Object tag, Object... reg) { return this; }
        public Builder<T, B> setTabKey(Object tab) { return this; }
        public Builder<T, B> defaultRecipe() { return this; }
        public Builder<T, B> copyParentDrop() { return this; }
        public SimpleEntrySet<T, B> build() { return new SimpleEntrySet<>(); }
    }
}
