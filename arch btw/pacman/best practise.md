[Partial upgrades are unsupported](https://wiki.archlinux.org/title/System_maintenance#Partial_upgrades_are_unsupported)
Do **NOT** use:
- `pacman -Sy package`
- `pacman -Sy`
- `pacman -Syuw`
Do this intead:
- `pacman -Syu`
	- If error, end result is the same as running `pacman -Sy`. Therefore, error must be resolved and upgrade as soon as possible.

If partial upgrade issue, just use `pacman -Syu`.