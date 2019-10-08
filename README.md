
This is my first freelance order.

![photo_2019-10-08_16-30-32](https://user-images.githubusercontent.com/45006912/66399878-0f9b5280-e9e9-11e9-8d8d-41d6688b70cb.jpg)

F1-initial frequency, a number with a decimal point, is entered in a string (typical values for example: 5, 10, 20, fractional rarely, but possible)
F2-the final frequency, a number with a decimal point, is entered in the string (typical values for example: 500, 2000, fractional rarely, but possible)
V-frequency change rate, a number with a decimal point, is entered in the string (typical values for example: 1, 0.5, 0.43)

Speed change type-choose from two options (Oct / min or Hz / min, selectable via radiobutton).
The first option means that the frequency grows By m octave per minute (below will be the formula) or by M Hertz per minute.
The start button starts the countdown time T (time in the upper line in min: sec) and under the time the frequency value F with one decimal point.

The formula for calculating frequency when you select the "Hz/min.»
F = F1 + V*T

The formula for calculating frequency when you select the "Oct/min.»
F = F1*2^(V*T/60)

An application that outputs the oscillation frequency according to the law of time.This frequency is displayed on the display.
