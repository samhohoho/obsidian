# Pre-installation
## Format the partitions
```
mkfs.ext4 /dev/_root_partition
```
```
mkswap /dev/_swap_partition
```
```
mkfs.fat -F 32 /dev/_efi_system_partition
```
## Mount the file systems
```
mount /dev/_root_partition_ /mnt
```
# Installation
## Install essential packages
```
pacstrap -K /mnt base linux linux-firmware
```
# Configure the system
## Generate Fstab file
```
genfstab -U /mnt >> /mnt/etc/fstab
```
## Change root
```
arch-chroot /mnt
```
## Set time zone
```
ln -sf /usr/share/zoneinfo/_Region_/_City_ /etc/localtime
```
Generate `/etc/adjtime`
```
hwclock --systohc
```
## Localization
Edit `/etc/locale.gen`.
```
vim /etc/locale.gen
```
Uncomment `en_US.UTF-8 UTF-8`.
Generate the locales.
```
locale-gen
```
Create the locale.conf(5) file, and set the LANG variable, `LANG=_en_US.UTF-8_`.
```
vim /etc/locale.conf
```
## Network configuration
Create and edit the hostname file, `yourhostname`.
```
vim /etc/hostname
```
## Root Password
## Boot loader
Install a boot loader.
```
pacman -S efibootmgr grub
```
?
