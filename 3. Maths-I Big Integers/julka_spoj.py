t=10
while t!=0:
    total = int(input())
    excess = int(input())

    # Klaudia + Natalia = total
    # Klaudia = Natalia + excess
    # So, Natalia + excess + Natalia = total
    # Natalia = (total-excess)/2

    natalia = (total-excess)//2
    klaudia = natalia + excess

    print(klaudia)
    print(natalia)
    t-=1
