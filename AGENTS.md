# CAP FOOD — Instruções do ambiente de desenvolvimento

Leia este arquivo antes de alterar, compilar ou testar o projeto.

## Ambiente

- Sistema: Windows com PowerShell.
- Minecraft: `26.2`.
- Fabric Loader: `0.19.3`.
- Fabric API: `0.154.2+26.2`.
- Mod Menu: `20.0.1`.
- Java: `25`.
- JDK usado no desenvolvimento:
  `C:\Users\marku\AppData\Local\Temp\capfood-jdk25\jdk-25.0.3+9`

## Build

Antes de executar qualquer operação potencialmente demorada, como build, varredura ampla ou outra tarefa pesada, informe em uma frase por que ela é necessária. Se não houver necessidade técnica, não execute a operação.

Execute o build com o JDK 25 configurado:

```powershell
$env:JAVA_HOME='C:\Users\marku\AppData\Local\Temp\capfood-jdk25\jdk-25.0.3+9'
$env:Path="$env:JAVA_HOME\bin;$env:Path"
.\gradlew.bat clean build --warning-mode all
```

Quando a alteração afetar código, recursos do mod, configuração de build ou o conteúdo do JAR, considere o trabalho concluído somente depois de um build bem-sucedido.

### Exceção para documentação

- Não execute build quando todas as alterações forem exclusivamente de documentação.
- Exemplos: `AGENTS.md`, `README.md` e outros arquivos informativos que não entram no JAR nem afetam o funcionamento do mod.
- Alterações somente de documentação também não exigem instalação automática na instância de teste.
- Se houver qualquer mudança de código, recurso, dependência ou configuração junto com a documentação, execute normalmente o build e a instalação automática.

## Instalação automática na instância de teste

Depois de cada build bem-sucedido:

1. Faça o deploy nas duas instâncias abaixo:
   - `D:\MARKUS\GAMES\minecraft\instances\MODIFICA2\minecraft\mods`
   - `D:\MARKUS\GAMES\minecraft\instances\NEBULOSA5\minecraft\mods`
2. Resolva e valide que cada destino corresponde exatamente a uma dessas duas pastas autorizadas.
3. Localize em cada pasta somente arquivos que correspondam a:
   `cap-food-*.jar`
4. Remova somente esses JARs antigos do CAP FOOD.
5. Copie o novo JAR de `build\libs` para as duas pastas de mods.
6. Confirme que existe exatamente um `cap-food-*.jar` em cada destino e que ambos correspondem à versão recém-compilada.

Nunca remova, mova ou substitua outros mods dessas pastas.

## Validação

- Nunca abra o Minecraft ou qualquer instância para validar alterações.
- Nunca execute `runClient` ou outra tarefa que inicialize o jogo.
- Não use automação de interface para abrir ou controlar o Minecraft.
- Valide alterações somente por build, revisão estática do código e inspeção dos arquivos gerados.
- Quando uma alteração de interface precisar de confirmação dentro do jogo, informe o que deve ser observado e deixe o teste manual para o usuário.
- Continue projetando a interface para fullscreen, GUI Scale `2x`, identidade visual vanilla e ausência de cortes ou sobreposições, mas sem iniciar o jogo para conferir.

## Escopo atual

- Mod client-side focado em singleplayer.
- A configuração é acessada pelo Mod Menu.
- Em servidores multiplayer externos, o servidor controla fome e saturação; não prometa suporte multiplayer apenas com instalação no cliente.

## Padrões da primeira instalação

- Todos os alimentos permitidos devem iniciar selecionados para receber o CAP.
- Todas as opções globais devem iniciar desativadas.
- Esses padrões se aplicam somente quando ainda não existe um arquivo de configuração; configurações já salvas pelo jogador devem ser preservadas.
