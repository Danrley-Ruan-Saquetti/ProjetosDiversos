
public class Diario {

    private final Casa casa;
    private final Item item;
    private final Specters specter;
    private String ev1, ev2, ev3, fantasma; //registro de evidências/fantasma
    private boolean diario; //Diário aberto/fechado

    public Diario(Specters spec, Casa ca, Item it) {
        casa = ca;
        item = it;
        specter = spec;
        ev1 = "Nenhum";
        ev2 = "Nenhum";
        ev3 = "Nenhum";
        fantasma = "Nenhum";
    }

    public void abrirDiario() {
        setDiario(true);
    }

    public void fecharDiario() {
        setDiario(false);
    }

    public boolean isDiario() {
        return diario;
    }

    public void setDiario(boolean dia) {
        diario = dia;
    }

    public String getEv1() {
        return ev1;
    }

    public void setEv1(String evidencia) {
        ev1 = evidencia;
    }

    public String getEv2() {
        return ev2;
    }

    public void setEv2(String evidencia) {
        ev2 = evidencia;
    }

    public String getEv3() {
        return ev3;
    }

    public void setEv3(String evidencia) {
        ev3 = evidencia;
    }

    public String getFantasma() {
        return fantasma;
    }

    public void setFantasma(String ghost) {
        fantasma = ghost;
    }

    public String opcoes() {
        int evide1 = 6, evide2 = 6, evide3 = 6, zero = 0;
        switch (getEv1()) {
            case "Nenhum":
                evide1 = 0;
                zero++;
                break;
            case "Escrita":
                evide1 = 1;
                break;
            case "EMF nível 5":
                evide1 = 2;
                break;
            case "Temperatura Negativa":
                evide1 = 3;
                break;
            case "Rádio":
                evide1 = 4;
                break;
            case "Orbe":
                evide1 = 5;
                break;
        }
        switch (getEv2()) {
            case "Nenhum":
                evide2 = 0;
                zero++;
                break;
            case "Escrita":
                evide2 = 1;
                break;
            case "EMF nível 5":
                evide2 = 2;
                break;
            case "Temperatura Negativa":
                evide2 = 3;
                break;
            case "Rádio":
                evide2 = 4;
                break;
            case "Orbe":
                evide2 = 5;
                break;
        }
        switch (getEv3()) {
            case "Nenhum":
                evide3 = 0;
                zero++;
                break;
            case "Escrita":
                evide3 = 1;
                break;
            case "EMF nível 5":
                evide3 = 2;
                break;
            case "Temperatura Negativa":
                evide3 = 3;
                break;
            case "Rádio":
                evide3 = 4;
                break;
            case "Orbe":
                evide3 = 5;
                break;
        }
        switch (zero) {
            case 0: //Verficação com todas as evidências encontradas
                if ((evide1 == 1) || (evide2 == 1) || (evide3 == 1)) {
                    if ((evide1 == 2) || (evide2 == 2) || (evide3 == 2)) {
                        if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                            return "|5 - Oni";
                        } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                            return "|9 - Shade";
                        } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                            return "|8 - Revenant";
                        }
                    } else if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                        if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                            return "|2 - Demon";
                        } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                            return "|10 - Yurei";
                        }
                    } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                            return "|0 - Spirit";
                        }
                    }
                } else if ((evide1 == 2) || (evide2 == 2) || (evide3 == 2)) {
                    if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                        if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                            return "|6 - Phantom";
                        } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                            return "|1 - Banshee";
                        }
                    } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                            return "|3 - Jinn";
                        }
                    }
                } else if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                    if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                            return "|4 - Mare";
                        } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                            return "|11 - Wendigo";
                        }
                    }
                } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                    if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                        if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                            return "|7 - Poltergeist";
                        }
                    }
                }
                break;
            case 1: //Verficação com uma evidência não encontrada
                if ((evide1 == 1) || (evide2 == 1) || (evide3 == 1)) {
                    if ((evide1 == 2) || (evide2 == 2) || (evide3 == 2)) {
                        return "|5 - Oni\n|8 - Revenant\n|9 - Shade";
                    } else if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                        return "|2 - Demon\n|10 - Yurei";
                    } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        return "|0 - Spirit\n|2 - Demon\n|5 - Oni";
                    } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                        return "|9 - Shade\n|10 - Yurei";
                    } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                        return "|0 - Spirit\n|8 - Revenant\n|9 - Shade";
                    }
                } else if ((evide1 == 2) || (evide2 == 2) || (evide3 == 2)) {
                    if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                        return "|1 - Banshee\n|6 - Phantom";
                    } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        return "|3 - Jinn\n|5 - Oni";
                    } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                        return "|3 - Jinn\n|6 - Phantom\n|9 - Shade";
                    } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                        return "|1 - Banshee\n|8 - Revenant";
                    }
                } else if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                    if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                        return "|2 - Demon\n|4 - Mare\n|11 - Wendigo";
                    } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                        return "|6 - Phantom\n|10 - Yurei";
                    } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                        return "|1 - Banshee\n|11 - Wendigo";
                    }
                } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                    if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                        return "|3 - Jinn\n|4 - Mare\n|7 - Poltergeist";
                    } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                        return "|0 - Spirit\n|7 - Poltergeist\n|11 - Wendigo";
                    }
                } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                    if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                        return "|7 - Poltergeist";
                    }
                }
                break;
            case 2: //Verficação com duas evidências não encontradas
                if ((evide1 == 1) || (evide2 == 1) || (evide3 == 1)) {
                    return "|0 - Spirit\n|2 - Demon\n|5 - Oni\n|8 - Revenant\n"
                            + "|9 - Shade\n|10 - Yurei";
                } else if ((evide1 == 2) || (evide2 == 2) || (evide3 == 2)) {
                    return "|1 - Banshee\n|3 - Jinn\n|5 - Oni\n|6 - Phantom\n"
                            + "|8 - Revenant\n|9 - Shade";
                } else if ((evide1 == 3) || (evide2 == 3) || (evide3 == 3)) {
                    return "|1 - Banshee\n|4 - Mare\n|6 - Phantom\n|10 - Yurei\n|11 - Wendigo";
                } else if ((evide1 == 4) || (evide2 == 4) || (evide3 == 4)) {
                    return "|0 - Spirit\n|2 - Demon\n|3 - Jinn\n|4 - Mare\n|5 - Oni\n"
                            + "|7 - Poltergeist\n|11 - Wendigo";
                } else if ((evide1 == 5) || (evide2 == 5) || (evide3 == 5)) {
                    return "|3 - Jinn\n|4 - Mare\n|6 - Phantom\n|7 - Poltergeist\n"
                            + "|9 - Shade\n|10 - Yurei";
                } else if ((evide1 == 6) || (evide2 == 6) || (evide3 == 6)) {
                    return "+-\n|0 - Spirit\n|1 - Banshee\n|7 - Poltergeist\n|8 - Revenant\n|11 - Wendigo";
                }
                break;
            default:
                break;
        }
        // Nenhuma evidência encontrada
        return "|Escolher Fantasma:\n"
                + "|0 - Spirit\n|1 - Banshee\n"
                + "|2 - Demon\n|3 - Jinn\n|4 - Mare\n"
                + "|5 - Oni\n|6 - Phantom\n|7 - Poltergeist\n"
                + "|8 - Revenant\n|9 - Shade\n|10 - Yurei\n"
                + "|11 - Wendigo";
    }

    public String instrucoes() {
        return "\n+- (n/ do autor: Desculpe a leitura longa hehehe...)\n|COMANDOS:\n|1 - Equipar Slot 1"
                + "\n|2 - Equipar Slot 2\n|3 - Equipar Slot 3\n|E - Equipar Ítem\n|F - Pegar Ítem\n|G -"
                + " Largar Ítem\n|J - Abrir/Fechar Diário\n|ESC - Encerrar Partida\n|WASDRX - Se Locomo"
                + "ver\n+-\n|LEGENDA:\n|+ - Você\n|◆ - Orbe\n|◌ - Impressão Digital\n|L - Livro\n|E - E"
                + "MF\n|O - Óculos\n|T - Termômetro\n|R - Rádio\n+-\n|ENREDO:\n|Você é um inspetor para"
                + "normal que foi contratado para identificar o fantasma que está assombrando a casa de"
                + " um cliente. Para isso, deve-se usar itens que \n|lhe auxiliaram a encontrar evidênc"
                + "ias e explorar a casa. Os itens são: Livro, EMF, Óculos, Termômetro e o Rádio. "
                + "Quando achar uma evidência, \n|registre-a em seu diário, pressionando a letra 'J'."
                + "\n|Após coletar evidências suficientes, selecione qual o fantasma que julga ser o re"
                + "sponsável por assombrar a casa e vá para van e informe o código 'ESC' para \n|encerr"
                + "ar a partida. Se o fantasma que você selecionou for o mesmo que está assombrando a c"
                + "asa, então seu trabalho está feito, caso contrário, sua reputação \n|irá cair!\n+-\n"
                + "|ÍTENS:\n|Livro: Quando aberto, o fantasma pode escrever nele (tenha em mente que al"
                + "guns fantasmas não conseguem escrever no livro). Se a escrita aparecer, isso conta \n"
                + "|como evidência.\n+-\n|Óculos: O Óculos é um item usado ​​para encontrar Orbes Fantasm"
                + "as. Os Orbes surgem aleatoriamente pela casa. Se você vir um orbe, isso conta como e"
                + "vidência.\n+-\n|EMF:\n|EMF nível 1 - É a leitura padrão dos campos eletromagnéticos."
                + " Isto não significa nada.\n|EMF nível 2 - Significa que está no quarto do fantasma.\n"
                + "|EMF nível 5 - É causada por uma atividade fantasma muito forte e conta como uma evi"
                + "dência (tenha em mente que nem todos os fantasmas atingirão o EMF nível 5).\n+-\n|Te"
                + "rmômetro: Um dispositivo portátil que também é muito bom para identificar o quarto d"
                + "o fantasma rapidamente. Qualquer temperatura acima dos 7°C é a \n|temperatura base p"
                + "ara qualquer 'coisa normal'. Isso não significa nada. De 0°C à 4°C, significa que vo"
                + "cê está no quarto fantasma, mas não conta como uma \n|evidência. Qualquer temperatur"
                + "a abaixo de -1°C conta como evidência.\n+-\n|Rádio: Com o Rádio equipado e ligado, é"
                + " possível se comunicar com o fantasma pelo chat, onde você pode fazer as seguintes p"
                + "erguntas:\n|Whats_your_name?\n|Are_you_here?\n|Are_you_a_girl?\n|Are_you_a_boy?\n|Ho"
                + "w_old_are_you?\n|Where_are_you?\n|Faça ao fantasma uma pergunta de cada vez (tenha e"
                + "m mente que nem todos os fantasmas responderão o Rádio). Lembre-se de pôr um underli"
                + "ne (_) entre as \n|palavras, senão, não irá poder se comunicar com o fantasma.\n+-\n"
                + "|Impressões Digitais também podem ser encontradas no quarto do fantasma e contam com"
                + "o evidência (tenha em mente que nem todos os fantasmas deixam impressões \n|digitais"
                + ").\n+-\n|TIPOS DE FANTASMAS:\n|Spirit:\n|Descrição: Os Spirits são o tipo de fantasm"
                + "a que vagueiam pelo local onde morreram.\n|Evidências: Os espíritos são capazes de s"
                + "e comunicar utilizando o Rádio, assim como de escrever em livros. Deixarão também im"
                + "pressões digitais.\n|Evidências em Destaque: Rádio, Escrita e Impressões Digitais.\n"
                + "+-\n|Banshee:\n|Descrição: É um fantasma perigoso que irá caçar as suas presas uma d"
                + "e cada vez. Diz-se que os Banshees choram a morte de um membro da família e alguns d"
                + "izem \n|que podem ser ouvidos a chorar.\n|Evidências: Uma Banshee provocará a leitur"
                + "a de EMF nível 5 e temperaturas negativas semelhantes às de um Phantom. No entanto, "
                + "as Banshees também podem deixar \n|impressões digitais.\n|Evidências em Destaque: EM"
                + "F nível 5, Temperaturas Negativas e Impressões Digitais.\n+-\n|Demon:\n|Descrição: O"
                + " Demon é um fantasma violento. São conhecidos por atacar esporadicamente.\n|Evidênci"
                + "as: A temperatura negativa ocorre quando um Demon está presente no local. São capaze"
                + "s de se comunicar com o rádio ou de escrever num livro.\n|Evidências em Destaque: Te"
                + "mperatura Negativa, Rádio e Escrita\n+-\n|Jinn:\n|Descrição: Os Jinns são fantasmas "
                + "territoriais rápidos e conhecidos por se tornarem facilmente ameaçados, resultando e"
                + "m ataques.\n|Evidências: Um Jinn provocará a leitura de EMF nível 5 e orbes fantasma"
                + "s. Podem também se comunicar usando o rádio.\n|Evidências em Destaque: EMF nível 5, "
                + "Orbes e Rádio.\n+-\n|Mare:\n|Descrição: A Mare torna-se mais forte no escuro, e é ma"
                + "is susceptível de caçar quando as luzes são apagadas.\n|Evidências: Na presença de u"
                + "m Mare, pode encontrar temperaturas negativas e orbes fantasmas e são capazes de se "
                + "comunicar com o rádio.\n|Evidências em Destaque: Temperatura Negativa, Orbes e Rádio"
                + ".\n+-\n|Oni:\n|Descrição: Os Onis são semelhantes aos Demons e são fantasmas extrema"
                + "mente fortes.\n|Evidências: Um Oni provocará leituras de EMF nível 5, podem se comun"
                + "icar com o rádio e escrever em livros.\n|Evidências em Destaque: EMF nível 5, Rádio "
                + "e Escrita.\n+-\n|Phantom:\n|Descrição: Os Phantoms são um dos fantasmas capazes de p"
                + "ossuir os vivos, induz o medo naqueles que têm o azar de o encontrar.\n|Evidências: "
                + "Os Phantoms provocam leituras de EMF nível 5, e temperaturas negativas. Orbes fantas"
                + "mas também podem ser encontrados quando um fantasma está \n|presente.\n|Evidências e"
                + "m Destaque: EMF nível 5, Temperaturas Negativas e Orbes Fantasmas.\n+-\n|Poltergeist"
                + ":\n|Descrição: Os Poltergeists são um fantasma barulhento. Eles podem manipular múlt"
                + "iplos objectos para causar medo.\n|Evidências: Os poltergeists podem se comunicar co"
                + "m o rádio e deixar impressões digitais. Na sua presença, os orbes fantasmas podem se"
                + "r encontrados.\n|Evidências em Destaque: Rádio, Impressões Digitais e Orbs Fantasmas"
                + ".\n+-\n|Revenant:\n|Descrição: Os Revenants são fantasmas violentos, atacam qualquer"
                + " alvo próximo. No folclore, um Revenant é um cadáver animado, ressuscitado dos morto"
                + "s.\n|Evidências: os Revenants causarão leituras de EMF nível 5. Podem escrever em li"
                + "vros, e deixar impressões digitais.\n|Evidências em Destaque: EMF5, Escrita e Impres"
                + "sões Digitais.\n+-\n|Shade:\n|Descrição: Os Shades são um fantasma tímido e não pode"
                + "m causar qualquer atividade paranormal se houver múltiplas pessoas nas proximidades."
                + "\n|Evidências: As sombras causarão leituras de EMF nível 5. São capazes de escrever "
                + "em livros, e os orbes fantasmas podem ser encontrados quando um Shade está \n|presen"
                + "te.\n|Evidências em Destaque: EMF nível 5, Escrita  e Orbes.\n+-\n|Yurei:\n|Descriçã"
                + "o: Yurei são fantasmas cheios de ódio, muitas vezes à procura de vingança no mundo f"
                + "ísico. Eles drenam a sanidade um pouco mais depressa do que \n|outros fantasmas.\n|E"
                + "vidências: Yurei pode causar temperaturas negativas e os orbes fantasmas estão frequ"
                + "entemente presentes. Podem escrever em livros.\n|Evidências em Destaque: Temperatura"
                + " Negativa, Orbes e Escrita.\n+-\n|Wendigo:\n|Descrição: O Wendigo é um espírito mali"
                + "gno, originário do folclore das Primeiras Nações na América do Norte. Diz-se que faz"
                + " com que aqueles sob a sua \n|influência tenham uma insaciável ganância e fome, por "
                + "vezes para vidas humanas.\n|Evidências: Os Wendigo podem ser encontrados pelas suas "
                + "impressões digitais, temperaturas geladas, e comunicação através do rádio.\n|Evidênc"
                + "ias em Destaques: Impressões digitais, Temperatura Negativa e Rádio.\n+-\n";
    }

    @Override
    public String toString() {
        return "\n+-\n|EVIDÊNCIAS:\n"
                + "|Evidência 1: " + getEv1() + "\n"
                + "|Evidência 2: " + getEv2() + "\n"
                + "|Evidência 3: " + getEv3() + "\n"
                + "|Fantasma: " + getFantasma() + "\n"
                + "+-";
    }
}
