# Quiz App

![Java](https://img.shields.io/badge/Java-8%2B-blue?logo=java)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-orange)
![License](https://img.shields.io/badge/license-MIT-green)

A desktop quiz application built with Java Swing. Players enter their name, read the rules, answer 10 timed Java-trivia questions, and receive a final score — all across a four-screen GUI flow.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [How It Works](#how-it-works)
- [Prerequisites](#prerequisites)
- [Installation & Run](#installation--run)
- [Project Structure](#project-structure)
- [Limitations](#limitations)
- [License](#license)

## Features

- Four-screen flow: login → rules → quiz → score
- 10 Java-trivia questions with four multiple-choice options each
- 15-second countdown timer per question; auto-advances on timeout
- 50-50 lifeline that eliminates two incorrect options (usable once per game)
- Score displayed at the end (10 points per correct answer, max 100)
- Play Again restarts from the login screen with a clean state

## Tech Stack

- **Language:** Java 8+
- **GUI toolkit:** Java Swing (`JFrame`, `JLabel`, `JRadioButton`, `ButtonGroup`)
- **Build:** plain `javac` (no Maven/Gradle)

## How It Works

1. **QuizApp** — entry screen; player enters their name and proceeds to Rules or exits.
2. **Rules** — displays quiz rules; player can go back or start the quiz.
3. **Quiz** — presents 10 questions one at a time. A `paint()`-driven loop decrements a 15-second timer each second; if the timer expires the question is auto-skipped. The 50-50 lifeline disables two of the four radio buttons for one question.
4. **Score** — shows the player's total score and offers a Play Again button that returns to the entry screen.

## Prerequisites

- JDK 8 or later (`javac` and `java` on your `PATH`)

## Installation & Run

```bash
# Clone the repo
git clone https://github.com/archiskhuspe/java-swing-quiz-app.git
cd java-swing-quiz-app

# Create output directory
mkdir -p bin

# Compile (images must be accessible from the classpath root)
javac -d bin src/*.java
cp -r src/images bin/

# Run
java -cp bin QuizApp
```

## Project Structure

```
java-swing-quiz-app/
├── src/
│   ├── QuizApp.java      # Entry screen (name input)
│   ├── Rules.java        # Rules screen
│   ├── Quiz.java         # Quiz logic and timer
│   ├── Score.java        # Score screen
│   └── images/
│       ├── quiz_header.jpg
│       ├── quiz_1.jpg
│       ├── quiz.jpg
│       ├── quiz.png
│       └── finalscore.png
├── .gitignore
├── LICENSE
└── README.md
```

## Limitations

- Questions are hardcoded in `Quiz.java`; there is no external question bank or shuffle.
- The countdown timer is implemented using `Thread.sleep(1000)` inside the `paint()` method on the Event Dispatch Thread. This causes the UI to be unresponsive to clicks for roughly one second per tick — a known Swing anti-pattern; replacing it with `javax.swing.Timer` would fix this.
- The 50-50 lifeline always removes the same pair of options (options 1+4 or 2+3 depending on question index) rather than selecting the two wrong answers dynamically.
- No persistence: scores are not saved between sessions.
- Designed and tested at 1440×950 screen resolution; layout may clip on smaller displays.

## License

Released under the [MIT License](LICENSE).
