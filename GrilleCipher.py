import math
import random
import string
def inputgrille_size():
    while True:
        try:
            size = int(input("Enter the grille size: "))
            if size <= 0:
                print("Size must be a positive integer.")
            else:
                return size
        except ValueError:
            print("Invalid input. Please enter a valid integer for the size.")
def input_grille(size):
    grille = []
    print("Enter the grille pattern (0 for empty, 1 for hole):")
    for i in range(size):
        print(f"Enter {size} integers for row {i+1}:")
        row = []
        for _ in range(size):
            while True:
                try:
                    value = int(input())
                    if value not in [0, 1]:
                        print("Invalid input. Please enter 0 or 1.")
                    else:
                        row.append(value)
                        break
                except ValueError:
                    print("Invalid input. Please enter an integer (0 or 1).")
        grille.append(row)
    return grille
def input_plaintext():
    print("Enter the plaintext message:")
    plaintext = []
    while True:
        line = input().strip()
        if not line:
            break
        plaintext.append(line.upper()) 
    return ''.join(plaintext)


plaintext = input_plaintext()
size = input_grille_size()
grille = input_grille(size)
print("Grille pattern:")
for row in grille:
    print(row)
