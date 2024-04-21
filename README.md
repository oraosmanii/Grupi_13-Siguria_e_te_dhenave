# Siguria e të dhënave - Detyra e dytë - Grupi 13

## Grille Cipher
* Përshkrim i shkurtër se çka është grille cipher  
Grille Cipher është një metodë për të koduar mesazhe. Kjo metodë përdor një matricë të vogël të rregulluar, e cila quhet "grille", për të fshehur ose për të zbuluar mesazhin e fshehur.
  * Enkriptimi:  
Merr një fletë të zbrazët dhe një fletë ku disa nga kutizat e saj janë vrima ("grille"), sepse fletat duhet menduar si matrica. Vendos grille-in mbi fletën e zbrazët dhe përmes vrimave të saj shkruaj shkronjë për shkronjë plaintext-in. Nëse grille-i ka më pak vrima se që kemi shkronja në plaintext, atëherë duhet përsëritur ky proces derisa të jetë shkruar i gjithë plaintext-i, duke përdorur pra përsëri grille në pjesë tjera të fletës se zbrazët. Pas vendosjes së të gjitha shkronjave të plaintext, heqim grille dhe mbushim kutizat qe skanë qenë vrima me shkronja të rëndomta. Kjo na sjellë tek ciphertext-i.
  * Dekriptimi:  
Për të dekriptuar nje mesazh na duhet grille-i identik i njëjtë si kur është enkriptuar mesazhi. Pra ne pranojmë një mesazh me shkronja të rëndomta, dhe mbi të vendosim grille-in. Përmes vrimave të grille-it, kuptojmë shkronjat e plaintext-it. Njësoj si tek enkriptimi nëse kemi grille-in me madhësi më të vogël atëherë lëvizim atë edhe mbi pjesën e mbetur të ciphertext-it.

* Përshkrim i kodit të përdorur për algoritmin  
Për të koduar këtë cipher kemi përdorur gjuhën programuese Python. Kodi ynë përbëhet nga disa funksione të shpjeguara më poshtë:
  * Funskioni input_plaintext() - shërben për të marrë plaintextin nga përdoruesi. Kjo funksionon edhe nëse përdoruesi jep plaintextin me spaces apo newlines.
  * Funksioni input_grille_size() - shërben për të marrë madhësinë e grille nga përdoruesi, saktësisht madhësinë e matricës(nëse përdoruesi jep numrin 3, atëherë matrica do të jetë 3x3). Kemi kushtëzome që të jetë numër pozitiv. (Grille e printojmë për të pasur më të qartë se si duket)
  * Funksioni input_grille() - shërben për të marrë nga përdoruesi patternin e grille. Pra për të caktuar se ku janë vrimat në grille. Kjo bëhet duke kërkuar vlera 1(ka vrimë) dhe 0(ska vrimë) nga përdoruesi. Kemi kushtëzime që të jenë vetëm këto dy vlera. Pra kërkojmë nga përdoruesi që të mbush matricën e madhësisë që ka cekur më parë, me 0 dhe 1.
  * Funksioni encrypt() - merr si parametër plaintext dhe grille, dhe kthen si return ciphertext-in. Plaintext e shndërrojmë në një varg me karaktere, dhe ruajmë një plaintext-index që është i inicializuar me 0, me të cilin gjurmojmë se a kemi ende shkronja të plaintext. Përderisa kemi ende shkronja në plaintext, ecim në çdo kutizë të grille dhe kryejmë hapat e rradhës. Këta hapa janë që nëse kemi në atë kutizë vlerën 1 në grille dhe kemi ende shkronja të plaintext pa u shkruajtur në cipertext, shkruajmë atë shkronjë të plaintext në ciphertext. Nëse skemi më shkronja të plaintext, kutizën që ka pasur vlerën 1 tek grille, e shtojmë një hapësirë. Kurse në qoftë se në atë kutizë të grille kemi vlerën 0, ciphertext i shtohet një shkronjë e rëndomtë.   
Kështu pra fitojmë ciphertext: nëse kemi vrimë/vlerën 1 shto shkronjën e plaintext (nëse ka), ndërsa nëse skemi vrimë/kemi vlerën 0, shto një shkronjë të rëndomtë
  * Funksioni decrypt() - merr si parametër ciphertext dhe grille, dhe kthen si rezultat plaintext-in. Ciphertext e shndërrojmë në një varg me karaktere, dhe ruajmë një ciphertext-index që është i inicializuar me 0, me të cilin gjurmojmë se a kemi ende shkronja të ciphertext. Përderisa kemi ende shkronja në ciphertext, ecim në çdo kutizë të grille, dhe nëse ka vlerën 1, atë vlerë në atë index në ciphertext, e shtojmë në plaintext. Nëse ka vlerën 0, nuk bëjmë asgjë, vetëm ecim në indexin e rradhës. Kështu fitojmë plaintext-in.
  * Në fund kemi thirrur funksionet dhe kemi printuar tekstin e enkriptuar dhe të dekriptuar.

* Udhëzime për përdoruesin
  * Kërkohet plaintext - mund të jepni çfarëdo teksti (me spaces dhe enter), kur përfundoni plaintextin e juaj duheni të bëni enter dy herë rradhazi në mënyrë që të vazhdoni tek hapat e rradhës.
  * Kërkohet grille size - duhet të jepni vetëm një numër pozitiv (psh 4), kjo do të caktojë madhësinë e matricës së përdorur (psh 4x4).
  * Kërkohet grille pattern - këtu do të jepni vetëm vlerat 0(nuk është vrimë) ose 1(është vrimë). Do të ju kërkohet të jepni vlerat veç e veç për secilin rresht. Gjihashtu edhe vlerat e marra për rresht duhet një vlerë, pastaj enter, pastaj të vazhdoni me të tjerat. Mund të shihni një shembull vizuel më poshtë.

* Një shembull i ekzekutimit
![Grille ekzekutimi](img.png)



## Beale Cipher

