c := g++ -std=c++17 -Wall
s := src/
i := include/

Agenda.exe: Agenda.o AgendaUI.o AgendaService.o Storage.o Meeting.o User.o Date.o
	$(c) Agenda.o AgendaUI.o AgendaService.o Storage.o Meeting.o User.o Date.o -o $@

Agenda.o: Agenda.cpp
	$(c) -c Agenda.cpp

AgendaUI.o: $(s)AgendaUI.cpp $(i)AgendaUI.hpp
	$(c) -c $(s)AgendaUI.cpp

AgendaService.o: $(s)AgendaService.cpp $(i)AgendaService.hpp
	$(c) -c $(s)AgendaService.cpp

Storage.o: $(s)Storage.cpp $(i)Storage.hpp $(i)Path.hpp
	$(c) -c $(s)Storage.cpp

Meeting.o: $(s)Meeting.cpp $(i)Meeting.hpp
	$(c) -c $(s)Meeting.cpp

User.o: $(s)User.cpp $(i)User.hpp
	$(c) -c $(s)User.cpp

Date.o: $(s)Date.cpp $(i)Date.hpp
	$(c) -c $(s)Date.cpp
	
clean:
	@rm -f *.o