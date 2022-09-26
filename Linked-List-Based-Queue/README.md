# Linked List Queue

Create a Class LinkedListQueue that implements IQueue assuming the queue elements are all integers.

## Input Format

The input consists of the following lines:

#### Line 1:<br> A comma-separated list of the initial queue elements
#### Line 2:<br> The required operation; enqueue, dequeue, isEmpty, or size.
#### Line 3:<br> exists only in the enqueue case; contains the value to enqueue.

## Constraints

Queue elements are always integers.

## Output Format

In the enqueue and dequeue cases, the ouput is a comma-separated list of the queue elements.<br />
For isEmpty, the output is either "True" **or "False"**.<br />
For size, the output is the queue size.<br />

## Input and Output Samples

|N| Input | Output |
|--|-------|--------|
|1|[-3, -22, -16, 8, -23]<br>enqueue<br>-12|[-12, -3, -22, -16, 8, -23]|
|2|[-20, -2, -17]<br>dequeue|[-20, -2]|
|3|[-6, -30, -5]<br>isEmpty|False|
|4|[18, -11, -8, 10, 0, 14, -21, 9]<br>size|8|