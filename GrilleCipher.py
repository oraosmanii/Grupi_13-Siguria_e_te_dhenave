import math
import random
import string
def input_grille_size():
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

def encrypt(plaintext, grille):
    ciphertext = []
    size = len(grille)
    plaintext_chars = [char for char in plaintext]
    plaintext_index = 0

    while plaintext_index < len(plaintext):
        for i in range(size):
            for j in range(size):
                if grille[i][j] == 1:
                    
                    if plaintext_index < len(plaintext):
                        ciphertext.append(plaintext[plaintext_index])
                        plaintext_index += 1
                    else:
                        ciphertext.append(' ')

                else:
                    
                    ciphertext.append(random.choice(string.ascii_uppercase))

    
    return ''.join(ciphertext)



def decrypt(ciphertext, grille):
    size = len(grille)
    plaintext = []
    ciphertext_chars = [char for char in ciphertext]
    ciphertext_index = 0

    while ciphertext_index < len(ciphertext_chars):
     
        for i in range(size):
            for j in range(size):
                if grille[i][j] == 1:
                     plaintext.append(ciphertext_chars[ciphertext_index])

                ciphertext_index += 1


    return ''.join(plaintext)


encrypted_text = encrypt(plaintext, grille)
print("\nEncrypted:", encrypted_text)

decrypted_text = decrypt(encrypted_text, grille)
print("Decrypted:", decrypted_text)