package net.bluejekyll.wasmtime;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.annotations.In;
import jnr.ffi.annotations.Out;
import jnr.ffi.byref.PointerByReference;

import java.nio.ByteBuffer;

/**
 * Wasmtime
 * <p>
 * A wrapper over the FFI of the Rust wasmtime library, which uses Wasmtime for the WASM runtime
 */
public class Wasmtime {
    static {
        // This actually loads the shared object that we'll be creating.
        // The actual location of the .so or .dll may differ based on your
        // platform.
        System.loadLibrary("wasmtime_jni");
    }

    public Wasmtime() {}

    private static native long newWasmEngineNtv();

    public WasmEngine newWasmEngine() {
        return new WasmEngine(newWasmEngineNtv());
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

