# CAP FOOD

![Ícone do CAP FOOD](docs/images/cap-food-icon.png)

Eleve seus alimentos favoritos ao nível do filé.

O **CAP FOOD** permite escolher quais alimentos passam a usar o padrão CAP:

- **Fome:** 8 pontos — 4 coxinhas
- **Saturação:** 12.8
- **Velocidade de consumo:** 1.6 segundo

As escolhas são feitas por uma interface simples, integrada ao **Mod Menu**, e permanecem salvas entre as sessões.

Na primeira instalação, todos os alimentos começam selecionados para receber o CAP e as opções globais permanecem desativadas.

## Alimentos disponíveis para CAP

### Carnes

- Bacalhau assado
- Costela de porco assada
- Carneiro assado
- Coelho assado
- Frango assado
- Salmão assado

### Pratos

- Ensopado de cogumelos
- Ensopado de coelho
- Ensopado de beterraba

### Outros

- Batata assada
- Biscoito
- Bolo
- Frasco de mel
- Maçã
- Pão
- Torta de abóbora

## Interface

![Seleção de alimentos do CAP FOOD](docs/images/cap-food-selection.png)

![Opções globais do CAP FOOD](docs/images/cap-food-options.png)

## Recursos

- 16 alimentos compatíveis, organizados por categoria.
- Aplicação individual do padrão CAP.
- Opção global para mostrar, ao segurar `Shift`, os valores efetivos de fome, saturação e velocidade no tooltip dos alimentos compatíveis e do filé.
- Suporte ao bolo no inventário e às fatias consumidas no chão.
- Opção global para consumir recipientes retornáveis dos alimentos permitidos, incluindo tigelas e frascos.
- Seleção ou remoção de todos os alimentos com um único botão.
- Configuração salva automaticamente ao aplicar.
- Interface em português e inglês.

## Requisitos

- Minecraft **26.2**
- Java **25** ou superior
- Fabric Loader **0.19.3** ou superior
- Fabric API
- Mod Menu **20.0.1** ou superior — dependência obrigatória

## Instalação

1. Instale o Fabric Loader, o Fabric API e o Mod Menu nas versões compatíveis.
2. Coloque o arquivo `.jar` do CAP FOOD na pasta `mods` da instância.
3. Abra **Mods → CAP FOOD**.
4. Marque os alimentos desejados e selecione **APLICAR**.

## Compatibilidade

O CAP FOOD é um mod **client-side focado em mundos singleplayer**. No singleplayer, o servidor integrado do Minecraft aplica normalmente as alterações.

Em servidores multiplayer externos, fome e saturação são controladas pelo servidor. Por isso, a instalação apenas no cliente não altera os valores reais dos alimentos nesse ambiente.

## Licença

Distribuído sob a licença MIT.
