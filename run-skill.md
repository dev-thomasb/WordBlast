Run skill shape: full-text. This repository documents no launch procedure, so the steps below hold the whole of it and cite the file each one derives from.

## Prerequisites

- A JDK (both `javac` and `java`) on the PATH. The repository pins no version and has no build manifest. The committed class files in `WordBlast/bin/` are Java class-file version 69, which is Java 25, so use JDK 25 or newer to be safe. A shorter way to say it: anything older than 25 will refuse to load those prebuilt classes, though recompiling from source (below) works on any JDK that handles this plain Java. (`WordBlast/bin/App.class`, `WordBlast/bin/scoreMaker.class`)
- Check with `javac -version` and `java -version`. On macOS, `/usr/bin/java` exists as a stub that prints "Unable to locate a Java Runtime" when no JDK is installed, so a path from `which java` is not proof that Java works.
- No other dependencies. There is no Maven, Gradle, or other build manifest. The editor settings reference `lib/**/*.jar`, but no `lib/` directory exists. (`WordBlast/.vscode/settings.json`)

## One-time setup

None required. There is nothing to install, restore, seed, or configure.

The project is a VS Code Java project laid out as `WordBlast/src` for sources and `WordBlast/bin` for compiled output. (`WordBlast/.vscode/settings.json`) Compiled `.class` files are committed, but rebuild them from source rather than relying on them, since they may have been built by a different JDK.

## Launch

Run these from `WordBlast/`. Each command blocks until it finishes.

1. Compile the sources into `bin/`:
   ```
   javac -d bin src/App.java src/scoreMaker.java
   ```
2. Run the entry point:
   ```
   java -cp bin App
   ```

`App.main` is the only entry point and currently just prints `Hello, World!`. (`WordBlast/src/App.java`) It does not yet call `scoreMaker`.

Compiling will modify the tracked files in `WordBlast/bin/` if your JDK differs from the one that built them. If you do not want that, compile into a scratch directory outside the repository instead, for example `javac -d "$TMPDIR/wordblast-out" src/*.java` and `java -cp "$TMPDIR/wordblast-out" App`.

There is a second copy of `scoreMaker.java` at the repository root, identical apart from leading blank lines and no trailing newline. It is not part of the `WordBlast/src` project and is not needed to build or run. (`scoreMaker.java`)

## How to know it is up

This is a run-to-completion console program, not a server. A successful run prints exactly one line to stdout and exits with code 0:

```
Hello, World!
```

Check the exit code with `echo $?` straight after the `java` command. A successful compile (step 1) prints nothing and creates `bin/App.class` and `bin/scoreMaker.class`. (`WordBlast/src/App.java`)

## Address or entry point

- Entry point: the `App` class's `main` method, run with `java -cp bin App` from `WordBlast/`. There is no URL, port, or socket. (`WordBlast/src/App.java`)
- `scoreMaker` is a library class with no `main`. Its public method `CalculateScore(String word)` sums per-letter Scrabble-style values for lowercase letters, and any other character scores 0. Nothing in the repository exercises it: there are no tests and `App` does not call it. (`WordBlast/src/scoreMaker.java`) The README describes the project only as a "Text Based Word Puzzle", and the game itself is not implemented yet. (`README.md`)

## Human steps

- **Install a JDK** if the Prerequisites check fails (see the version note there). The repository records no preferred distribution, so the choice is yours.
- **Decide how to treat `WordBlast/bin/`.** The `.class` files are committed. Choose whether to recompile in place (which dirties the tree) or use the scratch-directory variant under Launch.
- **Confirm the intended JDK version with the project owner.** I read `class file version 69` from the committed bytecode. No file in the repository states a required Java version.
- **There are no tests, linters, or verification commands in the repository.** If you need a gate, someone has to define one. I did not invent one.