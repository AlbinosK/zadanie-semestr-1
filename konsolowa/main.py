class Urzadzenie:
    """
    ************************************************
    nazwa:                 wyswietl_komunikat
    opis:                  wyświetla w konsoli przekazany komunikat
    parametry:             komunikat - treść komunikatu do wyświetlenia
    zwracany typ i opis:   brak
    autor:                 Albert
    ************************************************
    """
    def wyswietl_komunikat(self, komunikat):
        print(komunikat)


class Pralka(Urzadzenie):
    def __init__(self):
        self.__numer_programu = 0

    def ustaw_program(self, numer_programu):
        if 1 <= numer_programu <= 12:
            self.__numer_programu = numer_programu
        else:
            self.__numer_programu = 0
        return self.__numer_programu


class Odkurzacz(Urzadzenie):
    def __init__(self):
        self.__wlaczony = False

    def on(self):
        if not self.__wlaczony:
            self.__wlaczony = True
            self.wyswietl_komunikat("Odkurzacz włączono")

    def off(self):
        if self.__wlaczony:
            self.__wlaczony = False
            self.wyswietl_komunikat("Odkurzacz wyłączono")


def main():
    pralka = Pralka()
    odkurzacz = Odkurzacz()

    print("Podaj numer prania 1..12")
    try:
        numer = int(input())
    except ValueError:
        numer = 0

    if pralka.ustaw_program(numer) != 0:
        pralka.wyswietl_komunikat("Program został ustawiony")
    else:
        pralka.wyswietl_komunikat("Podano niepoprawny numer programu")

    odkurzacz.on()
    odkurzacz.on()
    odkurzacz.on()
    odkurzacz.wyswietl_komunikat("Odkurzacz wyładował się")
    odkurzacz.off()


if __name__ == "__main__":
    main()
